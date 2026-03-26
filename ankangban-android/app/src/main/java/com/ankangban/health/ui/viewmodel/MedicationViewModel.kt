package com.ankangban.health.ui.viewmodel

import android.app.Application
import android.net.Uri
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.ankangban.health.core.repo.MedicationRepository
import com.ankangban.health.core.alarm.AlarmScheduler
import com.ankangban.health.core.storage.HealthDatabase
import com.ankangban.health.core.storage.dao.MedicationDao
import com.ankangban.health.core.storage.entity.MedicationEntity
import com.ankangban.health.core.storage.entity.ReminderEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MedicationViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: MedicationRepository

    init {
        val db = HealthDatabase.get(application)
        repository = MedicationRepository(db.medicationDao())
    }

    val medications = repository.medicationsWithReminders

    private val _parseState = MutableStateFlow<ParseState>(ParseState.Idle)
    val parseState: StateFlow<ParseState> = _parseState.asStateFlow()

    sealed class ParseState {
        object Idle : ParseState()
        object Scanning : ParseState()
        object Analyzing : ParseState()
        data class Success(val result: com.ankangban.health.core.api.MedicationParseResponse) : ParseState()
        data class Error(val message: String) : ParseState()
    }

    fun analyzeImages(frontUri: Uri, sideUri: Uri?) {
        viewModelScope.launch {
            _parseState.value = ParseState.Scanning
            try {
                // 1. Recognize Text (Front - Mandatory)
                val frontOcrText = repository.recognizeText(getApplication(), frontUri)
                
                if (frontOcrText.startsWith("未识别") || frontOcrText.startsWith("识别失败") || frontOcrText.startsWith("处理异常")) {
                    _parseState.value = ParseState.Error("正面图片识别异常: $frontOcrText")
                    return@launch
                }

                // 2. Recognize Text (Side - Optional)
                var combinedText = "【药盒正面OCR内容】\n$frontOcrText"
                
                if (sideUri != null) {
                    val sideOcrText = repository.recognizeText(getApplication(), sideUri)
                    // Only append if successful
                    if (!sideOcrText.startsWith("未识别") && !sideOcrText.startsWith("识别失败") && !sideOcrText.startsWith("处理异常")) {
                        combinedText += "\n\n【药盒侧面/说明书OCR内容】\n$sideOcrText"
                    }
                }
                
                // 3. Call AI
                _parseState.value = ParseState.Analyzing
                val result = repository.parseMedicationFromOcr(combinedText)
                
                if (result != null) {
                    _parseState.value = ParseState.Success(result)
                } else {
                    _parseState.value = ParseState.Error("AI解析失败，请手动输入")
                }
            } catch (e: Exception) {
                _parseState.value = ParseState.Error("识别流程异常: ${e.message}")
            }
        }
    }
    
    fun resetParseState() {
        _parseState.value = ParseState.Idle
    }

    fun getMedication(id: Long): StateFlow<MedicationDao.MedicationWithReminders?> {
        val state = MutableStateFlow<MedicationDao.MedicationWithReminders?>(null)
        viewModelScope.launch {
            state.value = repository.getMedicationWithReminders(id)
        }
        return state
    }

    fun saveMedication(
        id: Long,
        name: String,
        dosage: String,
        frequency: String,
        stock: Int,
        unit: String,
        imageUri: String?,
        sideImageUri: String?,
        reminders: List<ReminderEntity>
    ) {
        viewModelScope.launch {
            // 1. Cancel existing alarms if updating
            if (id != 0L) {
                val oldData = repository.getMedicationWithReminders(id)
                oldData?.reminders?.forEach { reminder ->
                    AlarmScheduler.cancelReminder(getApplication(), id, reminder)
                }
            }

            val medication = MedicationEntity(
                id = id,
                name = name,
                dosage = dosage,
                frequency = frequency,
                totalStock = stock,
                unit = unit,
                imageUri = imageUri,
                sideImageUri = sideImageUri
            )
            
            val savedId = repository.saveMedication(medication, reminders)
            
            // 2. Schedule new alarms
            // Fetch saved data to get valid Reminder IDs (optional, but safer)
            val savedData = repository.getMedicationWithReminders(savedId)
            savedData?.reminders?.forEach { reminder ->
                if (reminder.isEnabled) {
                    AlarmScheduler.scheduleReminder(getApplication(), savedData.medication, reminder)
                }
            }
        }
    }

    fun deleteMedication(medication: MedicationEntity) {
        viewModelScope.launch {
            // Cancel alarms before deleting
            val oldData = repository.getMedicationWithReminders(medication.id)
            oldData?.reminders?.forEach { reminder ->
                AlarmScheduler.cancelReminder(getApplication(), medication.id, reminder)
            }
            
            repository.deleteMedication(medication)
        }
    }
}
