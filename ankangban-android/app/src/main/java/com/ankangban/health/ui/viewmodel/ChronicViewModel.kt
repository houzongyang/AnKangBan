package com.ankangban.health.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.ankangban.health.core.repo.ChronicRepository
import com.ankangban.health.core.storage.*
import com.ankangban.health.features.chronic.logic.ChronicDiseaseRiskEvaluator
import com.ankangban.health.features.chronic.logic.PlanGenerator
import com.ankangban.health.core.ai.HunyuanAiHelper
import org.json.JSONObject
import org.json.JSONArray
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class ChronicViewModel(application: Application) : AndroidViewModel(application) {

    private val db = HealthDatabase.get(application)
    private val repository = ChronicRepository(db)
    private val healthRepository = com.ankangban.health.core.repo.HealthRepository(
        client = com.ankangban.health.core.oppo.OppoHealthClientImpl(application),
        store = com.ankangban.health.core.storage.HealthLocalStore(application)
    )
    private val userManager = UserManager(application) // Assuming UserManager exists and has simple API

    // UI State
    private val _currentType = MutableStateFlow(ChronicDiseaseType.HYPERTENSION)
    val currentType: StateFlow<ChronicDiseaseType> = _currentType.asStateFlow()

    private val _riskState = MutableStateFlow<ChronicRiskEntity?>(null)
    val riskState: StateFlow<ChronicRiskEntity?> = _riskState.asStateFlow()

    private val _dailyPlans = MutableStateFlow<List<ChronicPlanEntity>>(emptyList())
    val dailyPlans: StateFlow<List<ChronicPlanEntity>> = _dailyPlans.asStateFlow()
    
    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> = _loading.asStateFlow()

    init {
        loadData()
    }

    fun switchType(type: ChronicDiseaseType) {
        _currentType.value = type
        loadData()
    }

    private var riskJob: kotlinx.coroutines.Job? = null

    private fun loadData() {
        _loading.value = true
        observeRisk()
        loadPlans()
    }

    private fun observeRisk() {
        riskJob?.cancel()
        riskJob = viewModelScope.launch {
            repository.getLatestRisk(_currentType.value).collect { record ->
                if (record == null) {
                    // Auto-evaluate if no record exists (First run)
                    evaluateRisk()
                } else {
                    _riskState.value = record
                    // If we have risk data, check if we can stop loading
                    if (_dailyPlans.value.isNotEmpty()) {
                        _loading.value = false
                    }
                }
            }
        }
    }

    private fun loadPlans() {
        viewModelScope.launch {
            val type = _currentType.value
            val today = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())
            
            var plans = repository.getDailyPlans(today, type)
            if (plans.isEmpty()) {
                // Generate plans if empty
                val currentRisk = _riskState.value?.riskLevel ?: RiskLevel.MEDIUM // Default to Medium if null
                val newPlans = PlanGenerator.generateDailyPlans(type, currentRisk, today)
                repository.savePlans(newPlans)
                // Reload to get generated IDs
                plans = repository.getDailyPlans(today, type)
            }
            _dailyPlans.value = plans
            
            // Plans loaded, turn off loading
            _loading.value = false
        }
    }

    fun evaluateRisk() {
        viewModelScope.launch(Dispatchers.IO) {
            _loading.value = true
            kotlinx.coroutines.delay(1000) // Demo delay
            
            val type = _currentType.value
            
            // 1. Fetch real health data (7-day avg) from HealthRepository
            val end = System.currentTimeMillis()
            val start = end - 7L * 24 * 60 * 60 * 1000
            
            // Heart Rate
            val hrList = healthRepository.getHeartRateHistory(start, end)?.firstOrNull() ?: emptyList()
            val avgHr = if (hrList.isNotEmpty()) hrList.map { it.value }.average().toInt() else 75

            // Steps
            val stepsList = healthRepository.getStepsHistory(start, end)?.firstOrNull() ?: emptyList()
            // Daily average = total / 7
            val totalSteps = stepsList.sumOf { it.count }
            val steps = if (stepsList.isNotEmpty()) (totalSteps / 7.0).toInt() else 4500

            // 2. User Info
            val age = userManager.userAge
            val height = (userManager.userHeight.toDoubleOrNull() ?: 175.0) / 100.0
            val weight = userManager.userWeight.toDoubleOrNull() ?: 70.0
            val bmi = (weight / (height * height)).toFloat()
            
            // 3. Simulated BP (Not available in SDK)
            // Add some randomness for demo
            val avgSystolic = 135 + (Math.random() * 10).toInt()
            val avgDiastolic = 85 + (Math.random() * 5).toInt()

            // 4. Try AI Evaluation first, fallback to local rule
            var newRisk: ChronicRiskEntity? = null
            
            try {
                val prompt = """
                    作为专业慢病管理专家，请评估以下用户的${type.name}风险：
                    年龄：$age
                    BMI：${String.format("%.1f", bmi)}
                    平均血压：${avgSystolic}/${avgDiastolic} mmHg
                    平均心率：$avgHr bpm
                    日均步数：$steps
                    
                    请严格以纯JSON格式返回（不要包含markdown标记），格式如下：
                    {
                      "level": "LOW/MEDIUM/HIGH",
                      "score": 0-100,
                      "factors": ["风险因素1", "风险因素2"]
                    }
                    RiskLevel必须是 LOW, MEDIUM, HIGH 之一。
                """.trimIndent()
                
                val jsonStr = HunyuanAiHelper.analyzeHealthData(prompt)
                // Clean up markdown code blocks if present
                val cleanJson = jsonStr.replace("```json", "").replace("```", "").trim()
                
                val jsonObj = JSONObject(cleanJson)
                val levelStr = jsonObj.getString("level")
                val score = jsonObj.getInt("score")
                val factorsArr = jsonObj.getJSONArray("factors")
                val factorsList = mutableListOf<String>()
                for (i in 0 until factorsArr.length()) {
                    factorsList.add(factorsArr.getString(i))
                }
                // Add AI tag
                factorsList.add(0, "经腾讯混元大模型评估")
                
                newRisk = ChronicRiskEntity(
                    timestamp = System.currentTimeMillis(),
                    diseaseType = type,
                    riskLevel = RiskLevel.valueOf(levelStr.uppercase()),
                    riskScore = score,
                    riskFactorsJson = JSONArray(factorsList).toString()
                )
            } catch (e: Exception) {
                e.printStackTrace()
                // AI failed, fall back to local rule
            }

            if (newRisk == null) {
                newRisk = ChronicDiseaseRiskEvaluator.evaluate(
                    type, age, bmi, avgSystolic, avgDiastolic, avgHr, steps
                )
            }

            repository.saveRiskRecord(newRisk)
            
            // Also regenerate plans based on new risk
            val today = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())
            repository.clearPlans(today, type)
            loadPlans() // Reload will generate new ones
            
            _loading.value = false
        }
    }

    suspend fun fetchLatestEvidence(plan: ChronicPlanEntity): String? {
        return kotlinx.coroutines.withContext(Dispatchers.IO) {
            val title = plan.title
            when {
                title.contains("血压") -> {
                    // Try to fetch BP from repo (simulated if not supported)
                    // Since standard SDK doesn't have BP, we simulate a connected device reading
                    // In a real app, this would be: healthRepository.getLatestMetric("BP")
                    val sys = healthRepository.getLatestMetric("BP_SYS")?.value?.toInt() ?: (110..140).random()
                    val dia = healthRepository.getLatestMetric("BP_DIA")?.value?.toInt() ?: (70..90).random()
                    "$sys/$dia mmHg"
                }
                title.contains("血糖") -> {
                    val gluc = healthRepository.getLatestMetric("BLOOD_GLUCOSE")?.value
                    if (gluc != null) "$gluc mmol/L" else "5.6 mmol/L" // Simulate if missing
                }
                title.contains("心率") -> {
                    val hr = healthRepository.getLatestMetric("HEART_RATE")?.value?.toInt()
                    if (hr != null) "$hr bpm" else null
                }
                title.contains("步数") || title.contains("运动") -> {
                    // Steps is separate flow
                    val steps = healthRepository.steps.firstOrNull()
                    if (steps != null) "${steps.count} 步" else null
                }
                else -> null
            }
        }
    }

    fun updatePlanCompletion(
        plan: ChronicPlanEntity,
        isCompleted: Boolean,
        evidenceText: String? = null,
        evidenceSource: String? = null
    ) {
        viewModelScope.launch {
            val updated = plan.copy(
                isCompleted = isCompleted,
                completedTime = if (isCompleted) System.currentTimeMillis() else null,
                evidenceText = if (isCompleted) evidenceText else null,
                evidenceSource = if (isCompleted) evidenceSource else null
            )
            repository.updatePlan(updated)
            val currentList = _dailyPlans.value.toMutableList()
            val index = currentList.indexOfFirst { it.id == plan.id }
            if (index != -1) {
                currentList[index] = updated
                _dailyPlans.value = currentList
            }
        }
    }
}
