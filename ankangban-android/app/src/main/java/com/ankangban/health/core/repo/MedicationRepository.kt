package com.ankangban.health.core.repo

import com.ankangban.health.core.api.HunyuanService
import com.ankangban.health.core.api.MedicationParseResponse
import com.ankangban.health.core.storage.dao.MedicationDao
import com.ankangban.health.core.storage.entity.MedicationEntity
import com.ankangban.health.core.storage.entity.ReminderEntity
import kotlinx.coroutines.flow.Flow
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class MedicationRepository(private val dao: MedicationDao) {

    val allMedications: Flow<List<MedicationEntity>> = dao.getAllMedications()
    
    val medicationsWithReminders: Flow<List<MedicationDao.MedicationWithReminders>> = dao.getMedicationsWithReminders()

    suspend fun getMedicationWithReminders(id: Long): MedicationDao.MedicationWithReminders? {
        return dao.getMedicationWithRemindersById(id)
    }

    suspend fun getMedication(id: Long): MedicationEntity? {
        return dao.getMedicationById(id)
    }

    suspend fun saveMedication(medication: MedicationEntity, reminders: List<ReminderEntity>): Long {
        val id = if (medication.id == 0L) {
            dao.insertMedication(medication)
        } else {
            dao.updateMedication(medication)
            dao.deleteRemindersByMedicationId(medication.id)
            medication.id
        }
        
        val newReminders = reminders.map { it.copy(medicationId = id) }
        dao.insertReminders(newReminders)
        return id
    }
    
    suspend fun deleteMedication(medication: MedicationEntity) {
        dao.deleteMedication(medication)
    }

    suspend fun parseMedicationFromOcr(text: String): MedicationParseResponse? {
        return try {
            HunyuanService.parseMedicationInfo(text)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    suspend fun recognizeText(context: android.content.Context, uri: android.net.Uri): String {
        return suspendCoroutine { continuation ->
            try {
                val image = com.google.mlkit.vision.common.InputImage.fromFilePath(context, uri)
                val options = com.google.mlkit.vision.text.chinese.ChineseTextRecognizerOptions.Builder().build()
                val recognizer = com.google.mlkit.vision.text.TextRecognition.getClient(options)

                recognizer.process(image)
                    .addOnSuccessListener { visionText ->
                        val text = visionText.text
                        if (text.isBlank()) {
                            continuation.resume("未识别到文字，请重试")
                        } else {
                            continuation.resume(text)
                        }
                    }
                    .addOnFailureListener { e ->
                        e.printStackTrace()
                        continuation.resume("识别失败(${e.javaClass.simpleName}): ${e.message}")
                    }
            } catch (e: Exception) {
                e.printStackTrace()
                continuation.resume("处理异常(${e.javaClass.simpleName}): ${e.message}")
            }
        }
    }
}
