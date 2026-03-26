package com.ankangban.health.core.storage

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ankangban.health.core.storage.dao.MedicationDao
import com.ankangban.health.core.storage.entity.MedicationEntity
import com.ankangban.health.core.storage.entity.ReminderEntity

@Database(
    entities = [
        StepsEntity::class,
        HealthDataEntity::class,
        SleepDataEntity::class,
        ChronicRiskEntity::class,
        ChronicPlanEntity::class,
        SleepPlanEntity::class,
        SleepCheckInEntity::class,
        AiContentEntity::class,
        MedicationEntity::class,
        ReminderEntity::class
    ],
    version = 8,
    exportSchema = false
)
@androidx.room.TypeConverters(ChronicTypeConverters::class, SleepTypeConverters::class)
abstract class HealthDatabase : RoomDatabase() {
    abstract fun stepsDao(): StepsDao
    abstract fun healthDataDao(): HealthDataDao
    abstract fun sleepDao(): SleepDao
    abstract fun chronicDao(): ChronicDao
    abstract fun sleepPlanDao(): SleepPlanDao
    abstract fun sleepCheckInDao(): SleepCheckInDao
    abstract fun aiContentDao(): AiContentDao
    abstract fun medicationDao(): MedicationDao

    companion object {
        @Volatile private var INSTANCE: HealthDatabase? = null
        fun get(context: Context): HealthDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(context.applicationContext, HealthDatabase::class.java, "health.db")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { INSTANCE = it }
            }
        }
    }
}
