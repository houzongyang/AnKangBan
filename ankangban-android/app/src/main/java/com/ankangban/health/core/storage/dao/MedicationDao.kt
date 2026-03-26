package com.ankangban.health.core.storage.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import androidx.room.Delete
import androidx.room.Transaction
import com.ankangban.health.core.storage.entity.MedicationEntity
import com.ankangban.health.core.storage.entity.ReminderEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MedicationDao {
    // Medication Operations
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMedication(medication: MedicationEntity): Long

    @Update
    suspend fun updateMedication(medication: MedicationEntity)

    @Delete
    suspend fun deleteMedication(medication: MedicationEntity)

    @Query("SELECT * FROM medications ORDER BY create_time DESC")
    fun getAllMedications(): Flow<List<MedicationEntity>>

    @Query("SELECT * FROM medications WHERE id = :id")
    suspend fun getMedicationById(id: Long): MedicationEntity?

    // Reminder Operations
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertReminders(reminders: List<ReminderEntity>)

    @Query("SELECT * FROM reminders WHERE medication_id = :medicationId")
    fun getRemindersForMedication(medicationId: Long): Flow<List<ReminderEntity>>
    
    @Query("DELETE FROM reminders WHERE medication_id = :medicationId")
    suspend fun deleteRemindersByMedicationId(medicationId: Long)

    @Query("SELECT * FROM reminders WHERE is_enabled = 1")
    suspend fun getAllActiveReminders(): List<ReminderEntity>
    
    // Combined Data Class for easy UI consumption
    data class MedicationWithReminders(
        @androidx.room.Embedded val medication: MedicationEntity,
        @androidx.room.Relation(
            parentColumn = "id",
            entityColumn = "medication_id"
        )
        val reminders: List<ReminderEntity>
    )

    @Transaction
    @Query("SELECT * FROM medications ORDER BY create_time DESC")
    fun getMedicationsWithReminders(): Flow<List<MedicationWithReminders>>
    @Transaction
    @Query("SELECT * FROM medications WHERE id = :id")
    suspend fun getMedicationWithRemindersById(id: Long): MedicationWithReminders?
}
