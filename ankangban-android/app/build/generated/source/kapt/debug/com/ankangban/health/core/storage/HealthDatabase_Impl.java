package com.ankangban.health.core.storage;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.ankangban.health.core.storage.dao.MedicationDao;
import com.ankangban.health.core.storage.dao.MedicationDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class HealthDatabase_Impl extends HealthDatabase {
  private volatile StepsDao _stepsDao;

  private volatile HealthDataDao _healthDataDao;

  private volatile SleepDao _sleepDao;

  private volatile ChronicDao _chronicDao;

  private volatile SleepPlanDao _sleepPlanDao;

  private volatile SleepCheckInDao _sleepCheckInDao;

  private volatile AiContentDao _aiContentDao;

  private volatile MedicationDao _medicationDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(8) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `steps` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `timestamp` INTEGER NOT NULL, `count` INTEGER NOT NULL, `calories` REAL NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `health_data` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `type` TEXT NOT NULL, `value` REAL NOT NULL, `timestamp` INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `sleep_data` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `totalMinutes` INTEGER NOT NULL, `deepMinutes` INTEGER NOT NULL, `lightMinutes` INTEGER NOT NULL, `remMinutes` INTEGER NOT NULL, `efficiency` REAL NOT NULL, `startTime` INTEGER NOT NULL, `endTime` INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `chronic_risk_records` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `timestamp` INTEGER NOT NULL, `diseaseType` TEXT NOT NULL, `riskLevel` TEXT NOT NULL, `riskScore` INTEGER NOT NULL, `riskFactorsJson` TEXT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `chronic_plans` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `date` TEXT NOT NULL, `diseaseType` TEXT NOT NULL, `type` TEXT NOT NULL, `title` TEXT NOT NULL, `description` TEXT NOT NULL, `targetValue` TEXT, `isCompleted` INTEGER NOT NULL, `completedTime` INTEGER, `evidenceText` TEXT, `evidenceSource` TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `sleep_plans` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `date` TEXT NOT NULL, `dayIndex` INTEGER NOT NULL, `title` TEXT NOT NULL, `itemsJson` TEXT NOT NULL, `isCompleted` INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `sleep_checkins` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `date` TEXT NOT NULL, `qualityLevel` TEXT NOT NULL, `timestamp` INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `ai_content` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `title` TEXT NOT NULL, `content` TEXT NOT NULL, `type` TEXT NOT NULL, `tags` TEXT NOT NULL, `durationMinutes` INTEGER NOT NULL, `suggestedBgMusic` TEXT NOT NULL, `createdAt` INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `medications` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT NOT NULL, `dosage` TEXT NOT NULL, `frequency` TEXT NOT NULL, `total_stock` INTEGER NOT NULL, `unit` TEXT NOT NULL, `image_uri` TEXT, `side_image_uri` TEXT, `create_time` INTEGER NOT NULL, `ai_analysis_raw` TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `reminders` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `medication_id` INTEGER NOT NULL, `time_hour` INTEGER NOT NULL, `time_minute` INTEGER NOT NULL, `is_enabled` INTEGER NOT NULL, `label` TEXT, FOREIGN KEY(`medication_id`) REFERENCES `medications`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        db.execSQL("CREATE INDEX IF NOT EXISTS `index_reminders_medication_id` ON `reminders` (`medication_id`)");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '63435f2eec865c70d01ee3cd314ec525')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `steps`");
        db.execSQL("DROP TABLE IF EXISTS `health_data`");
        db.execSQL("DROP TABLE IF EXISTS `sleep_data`");
        db.execSQL("DROP TABLE IF EXISTS `chronic_risk_records`");
        db.execSQL("DROP TABLE IF EXISTS `chronic_plans`");
        db.execSQL("DROP TABLE IF EXISTS `sleep_plans`");
        db.execSQL("DROP TABLE IF EXISTS `sleep_checkins`");
        db.execSQL("DROP TABLE IF EXISTS `ai_content`");
        db.execSQL("DROP TABLE IF EXISTS `medications`");
        db.execSQL("DROP TABLE IF EXISTS `reminders`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        db.execSQL("PRAGMA foreign_keys = ON");
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsSteps = new HashMap<String, TableInfo.Column>(4);
        _columnsSteps.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSteps.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSteps.put("count", new TableInfo.Column("count", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSteps.put("calories", new TableInfo.Column("calories", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSteps = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesSteps = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoSteps = new TableInfo("steps", _columnsSteps, _foreignKeysSteps, _indicesSteps);
        final TableInfo _existingSteps = TableInfo.read(db, "steps");
        if (!_infoSteps.equals(_existingSteps)) {
          return new RoomOpenHelper.ValidationResult(false, "steps(com.ankangban.health.core.storage.StepsEntity).\n"
                  + " Expected:\n" + _infoSteps + "\n"
                  + " Found:\n" + _existingSteps);
        }
        final HashMap<String, TableInfo.Column> _columnsHealthData = new HashMap<String, TableInfo.Column>(4);
        _columnsHealthData.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHealthData.put("type", new TableInfo.Column("type", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHealthData.put("value", new TableInfo.Column("value", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHealthData.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysHealthData = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesHealthData = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoHealthData = new TableInfo("health_data", _columnsHealthData, _foreignKeysHealthData, _indicesHealthData);
        final TableInfo _existingHealthData = TableInfo.read(db, "health_data");
        if (!_infoHealthData.equals(_existingHealthData)) {
          return new RoomOpenHelper.ValidationResult(false, "health_data(com.ankangban.health.core.storage.HealthDataEntity).\n"
                  + " Expected:\n" + _infoHealthData + "\n"
                  + " Found:\n" + _existingHealthData);
        }
        final HashMap<String, TableInfo.Column> _columnsSleepData = new HashMap<String, TableInfo.Column>(8);
        _columnsSleepData.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSleepData.put("totalMinutes", new TableInfo.Column("totalMinutes", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSleepData.put("deepMinutes", new TableInfo.Column("deepMinutes", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSleepData.put("lightMinutes", new TableInfo.Column("lightMinutes", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSleepData.put("remMinutes", new TableInfo.Column("remMinutes", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSleepData.put("efficiency", new TableInfo.Column("efficiency", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSleepData.put("startTime", new TableInfo.Column("startTime", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSleepData.put("endTime", new TableInfo.Column("endTime", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSleepData = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesSleepData = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoSleepData = new TableInfo("sleep_data", _columnsSleepData, _foreignKeysSleepData, _indicesSleepData);
        final TableInfo _existingSleepData = TableInfo.read(db, "sleep_data");
        if (!_infoSleepData.equals(_existingSleepData)) {
          return new RoomOpenHelper.ValidationResult(false, "sleep_data(com.ankangban.health.core.storage.SleepDataEntity).\n"
                  + " Expected:\n" + _infoSleepData + "\n"
                  + " Found:\n" + _existingSleepData);
        }
        final HashMap<String, TableInfo.Column> _columnsChronicRiskRecords = new HashMap<String, TableInfo.Column>(6);
        _columnsChronicRiskRecords.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChronicRiskRecords.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChronicRiskRecords.put("diseaseType", new TableInfo.Column("diseaseType", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChronicRiskRecords.put("riskLevel", new TableInfo.Column("riskLevel", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChronicRiskRecords.put("riskScore", new TableInfo.Column("riskScore", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChronicRiskRecords.put("riskFactorsJson", new TableInfo.Column("riskFactorsJson", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysChronicRiskRecords = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesChronicRiskRecords = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoChronicRiskRecords = new TableInfo("chronic_risk_records", _columnsChronicRiskRecords, _foreignKeysChronicRiskRecords, _indicesChronicRiskRecords);
        final TableInfo _existingChronicRiskRecords = TableInfo.read(db, "chronic_risk_records");
        if (!_infoChronicRiskRecords.equals(_existingChronicRiskRecords)) {
          return new RoomOpenHelper.ValidationResult(false, "chronic_risk_records(com.ankangban.health.core.storage.ChronicRiskEntity).\n"
                  + " Expected:\n" + _infoChronicRiskRecords + "\n"
                  + " Found:\n" + _existingChronicRiskRecords);
        }
        final HashMap<String, TableInfo.Column> _columnsChronicPlans = new HashMap<String, TableInfo.Column>(11);
        _columnsChronicPlans.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChronicPlans.put("date", new TableInfo.Column("date", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChronicPlans.put("diseaseType", new TableInfo.Column("diseaseType", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChronicPlans.put("type", new TableInfo.Column("type", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChronicPlans.put("title", new TableInfo.Column("title", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChronicPlans.put("description", new TableInfo.Column("description", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChronicPlans.put("targetValue", new TableInfo.Column("targetValue", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChronicPlans.put("isCompleted", new TableInfo.Column("isCompleted", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChronicPlans.put("completedTime", new TableInfo.Column("completedTime", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChronicPlans.put("evidenceText", new TableInfo.Column("evidenceText", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChronicPlans.put("evidenceSource", new TableInfo.Column("evidenceSource", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysChronicPlans = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesChronicPlans = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoChronicPlans = new TableInfo("chronic_plans", _columnsChronicPlans, _foreignKeysChronicPlans, _indicesChronicPlans);
        final TableInfo _existingChronicPlans = TableInfo.read(db, "chronic_plans");
        if (!_infoChronicPlans.equals(_existingChronicPlans)) {
          return new RoomOpenHelper.ValidationResult(false, "chronic_plans(com.ankangban.health.core.storage.ChronicPlanEntity).\n"
                  + " Expected:\n" + _infoChronicPlans + "\n"
                  + " Found:\n" + _existingChronicPlans);
        }
        final HashMap<String, TableInfo.Column> _columnsSleepPlans = new HashMap<String, TableInfo.Column>(6);
        _columnsSleepPlans.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSleepPlans.put("date", new TableInfo.Column("date", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSleepPlans.put("dayIndex", new TableInfo.Column("dayIndex", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSleepPlans.put("title", new TableInfo.Column("title", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSleepPlans.put("itemsJson", new TableInfo.Column("itemsJson", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSleepPlans.put("isCompleted", new TableInfo.Column("isCompleted", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSleepPlans = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesSleepPlans = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoSleepPlans = new TableInfo("sleep_plans", _columnsSleepPlans, _foreignKeysSleepPlans, _indicesSleepPlans);
        final TableInfo _existingSleepPlans = TableInfo.read(db, "sleep_plans");
        if (!_infoSleepPlans.equals(_existingSleepPlans)) {
          return new RoomOpenHelper.ValidationResult(false, "sleep_plans(com.ankangban.health.core.storage.SleepPlanEntity).\n"
                  + " Expected:\n" + _infoSleepPlans + "\n"
                  + " Found:\n" + _existingSleepPlans);
        }
        final HashMap<String, TableInfo.Column> _columnsSleepCheckins = new HashMap<String, TableInfo.Column>(4);
        _columnsSleepCheckins.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSleepCheckins.put("date", new TableInfo.Column("date", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSleepCheckins.put("qualityLevel", new TableInfo.Column("qualityLevel", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSleepCheckins.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSleepCheckins = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesSleepCheckins = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoSleepCheckins = new TableInfo("sleep_checkins", _columnsSleepCheckins, _foreignKeysSleepCheckins, _indicesSleepCheckins);
        final TableInfo _existingSleepCheckins = TableInfo.read(db, "sleep_checkins");
        if (!_infoSleepCheckins.equals(_existingSleepCheckins)) {
          return new RoomOpenHelper.ValidationResult(false, "sleep_checkins(com.ankangban.health.core.storage.SleepCheckInEntity).\n"
                  + " Expected:\n" + _infoSleepCheckins + "\n"
                  + " Found:\n" + _existingSleepCheckins);
        }
        final HashMap<String, TableInfo.Column> _columnsAiContent = new HashMap<String, TableInfo.Column>(8);
        _columnsAiContent.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAiContent.put("title", new TableInfo.Column("title", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAiContent.put("content", new TableInfo.Column("content", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAiContent.put("type", new TableInfo.Column("type", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAiContent.put("tags", new TableInfo.Column("tags", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAiContent.put("durationMinutes", new TableInfo.Column("durationMinutes", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAiContent.put("suggestedBgMusic", new TableInfo.Column("suggestedBgMusic", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAiContent.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAiContent = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesAiContent = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAiContent = new TableInfo("ai_content", _columnsAiContent, _foreignKeysAiContent, _indicesAiContent);
        final TableInfo _existingAiContent = TableInfo.read(db, "ai_content");
        if (!_infoAiContent.equals(_existingAiContent)) {
          return new RoomOpenHelper.ValidationResult(false, "ai_content(com.ankangban.health.core.storage.AiContentEntity).\n"
                  + " Expected:\n" + _infoAiContent + "\n"
                  + " Found:\n" + _existingAiContent);
        }
        final HashMap<String, TableInfo.Column> _columnsMedications = new HashMap<String, TableInfo.Column>(10);
        _columnsMedications.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMedications.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMedications.put("dosage", new TableInfo.Column("dosage", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMedications.put("frequency", new TableInfo.Column("frequency", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMedications.put("total_stock", new TableInfo.Column("total_stock", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMedications.put("unit", new TableInfo.Column("unit", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMedications.put("image_uri", new TableInfo.Column("image_uri", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMedications.put("side_image_uri", new TableInfo.Column("side_image_uri", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMedications.put("create_time", new TableInfo.Column("create_time", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMedications.put("ai_analysis_raw", new TableInfo.Column("ai_analysis_raw", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysMedications = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesMedications = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoMedications = new TableInfo("medications", _columnsMedications, _foreignKeysMedications, _indicesMedications);
        final TableInfo _existingMedications = TableInfo.read(db, "medications");
        if (!_infoMedications.equals(_existingMedications)) {
          return new RoomOpenHelper.ValidationResult(false, "medications(com.ankangban.health.core.storage.entity.MedicationEntity).\n"
                  + " Expected:\n" + _infoMedications + "\n"
                  + " Found:\n" + _existingMedications);
        }
        final HashMap<String, TableInfo.Column> _columnsReminders = new HashMap<String, TableInfo.Column>(6);
        _columnsReminders.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReminders.put("medication_id", new TableInfo.Column("medication_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReminders.put("time_hour", new TableInfo.Column("time_hour", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReminders.put("time_minute", new TableInfo.Column("time_minute", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReminders.put("is_enabled", new TableInfo.Column("is_enabled", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReminders.put("label", new TableInfo.Column("label", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysReminders = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysReminders.add(new TableInfo.ForeignKey("medications", "CASCADE", "NO ACTION", Arrays.asList("medication_id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesReminders = new HashSet<TableInfo.Index>(1);
        _indicesReminders.add(new TableInfo.Index("index_reminders_medication_id", false, Arrays.asList("medication_id"), Arrays.asList("ASC")));
        final TableInfo _infoReminders = new TableInfo("reminders", _columnsReminders, _foreignKeysReminders, _indicesReminders);
        final TableInfo _existingReminders = TableInfo.read(db, "reminders");
        if (!_infoReminders.equals(_existingReminders)) {
          return new RoomOpenHelper.ValidationResult(false, "reminders(com.ankangban.health.core.storage.entity.ReminderEntity).\n"
                  + " Expected:\n" + _infoReminders + "\n"
                  + " Found:\n" + _existingReminders);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "63435f2eec865c70d01ee3cd314ec525", "2058b6f4c73a72d34833d93cb0ec7f4d");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "steps","health_data","sleep_data","chronic_risk_records","chronic_plans","sleep_plans","sleep_checkins","ai_content","medications","reminders");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    final boolean _supportsDeferForeignKeys = android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP;
    try {
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = FALSE");
      }
      super.beginTransaction();
      if (_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA defer_foreign_keys = TRUE");
      }
      _db.execSQL("DELETE FROM `steps`");
      _db.execSQL("DELETE FROM `health_data`");
      _db.execSQL("DELETE FROM `sleep_data`");
      _db.execSQL("DELETE FROM `chronic_risk_records`");
      _db.execSQL("DELETE FROM `chronic_plans`");
      _db.execSQL("DELETE FROM `sleep_plans`");
      _db.execSQL("DELETE FROM `sleep_checkins`");
      _db.execSQL("DELETE FROM `ai_content`");
      _db.execSQL("DELETE FROM `medications`");
      _db.execSQL("DELETE FROM `reminders`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = TRUE");
      }
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(StepsDao.class, StepsDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(HealthDataDao.class, HealthDataDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(SleepDao.class, SleepDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(ChronicDao.class, ChronicDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(SleepPlanDao.class, SleepPlanDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(SleepCheckInDao.class, SleepCheckInDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(AiContentDao.class, AiContentDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(MedicationDao.class, MedicationDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public StepsDao stepsDao() {
    if (_stepsDao != null) {
      return _stepsDao;
    } else {
      synchronized(this) {
        if(_stepsDao == null) {
          _stepsDao = new StepsDao_Impl(this);
        }
        return _stepsDao;
      }
    }
  }

  @Override
  public HealthDataDao healthDataDao() {
    if (_healthDataDao != null) {
      return _healthDataDao;
    } else {
      synchronized(this) {
        if(_healthDataDao == null) {
          _healthDataDao = new HealthDataDao_Impl(this);
        }
        return _healthDataDao;
      }
    }
  }

  @Override
  public SleepDao sleepDao() {
    if (_sleepDao != null) {
      return _sleepDao;
    } else {
      synchronized(this) {
        if(_sleepDao == null) {
          _sleepDao = new SleepDao_Impl(this);
        }
        return _sleepDao;
      }
    }
  }

  @Override
  public ChronicDao chronicDao() {
    if (_chronicDao != null) {
      return _chronicDao;
    } else {
      synchronized(this) {
        if(_chronicDao == null) {
          _chronicDao = new ChronicDao_Impl(this);
        }
        return _chronicDao;
      }
    }
  }

  @Override
  public SleepPlanDao sleepPlanDao() {
    if (_sleepPlanDao != null) {
      return _sleepPlanDao;
    } else {
      synchronized(this) {
        if(_sleepPlanDao == null) {
          _sleepPlanDao = new SleepPlanDao_Impl(this);
        }
        return _sleepPlanDao;
      }
    }
  }

  @Override
  public SleepCheckInDao sleepCheckInDao() {
    if (_sleepCheckInDao != null) {
      return _sleepCheckInDao;
    } else {
      synchronized(this) {
        if(_sleepCheckInDao == null) {
          _sleepCheckInDao = new SleepCheckInDao_Impl(this);
        }
        return _sleepCheckInDao;
      }
    }
  }

  @Override
  public AiContentDao aiContentDao() {
    if (_aiContentDao != null) {
      return _aiContentDao;
    } else {
      synchronized(this) {
        if(_aiContentDao == null) {
          _aiContentDao = new AiContentDao_Impl(this);
        }
        return _aiContentDao;
      }
    }
  }

  @Override
  public MedicationDao medicationDao() {
    if (_medicationDao != null) {
      return _medicationDao;
    } else {
      synchronized(this) {
        if(_medicationDao == null) {
          _medicationDao = new MedicationDao_Impl(this);
        }
        return _medicationDao;
      }
    }
  }
}
