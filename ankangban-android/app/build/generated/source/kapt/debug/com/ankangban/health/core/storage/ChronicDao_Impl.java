package com.ankangban.health.core.storage;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class ChronicDao_Impl implements ChronicDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ChronicRiskEntity> __insertionAdapterOfChronicRiskEntity;

  private final ChronicTypeConverters __chronicTypeConverters = new ChronicTypeConverters();

  private final EntityInsertionAdapter<ChronicPlanEntity> __insertionAdapterOfChronicPlanEntity;

  private final EntityDeletionOrUpdateAdapter<ChronicPlanEntity> __updateAdapterOfChronicPlanEntity;

  private final SharedSQLiteStatement __preparedStmtOfClearPlans;

  public ChronicDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfChronicRiskEntity = new EntityInsertionAdapter<ChronicRiskEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `chronic_risk_records` (`id`,`timestamp`,`diseaseType`,`riskLevel`,`riskScore`,`riskFactorsJson`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final ChronicRiskEntity entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getTimestamp());
        final String _tmp = __chronicTypeConverters.fromDiseaseType(entity.getDiseaseType());
        if (_tmp == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, _tmp);
        }
        final String _tmp_1 = __chronicTypeConverters.fromRiskLevel(entity.getRiskLevel());
        if (_tmp_1 == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, _tmp_1);
        }
        statement.bindLong(5, entity.getRiskScore());
        if (entity.getRiskFactorsJson() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getRiskFactorsJson());
        }
      }
    };
    this.__insertionAdapterOfChronicPlanEntity = new EntityInsertionAdapter<ChronicPlanEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `chronic_plans` (`id`,`date`,`diseaseType`,`type`,`title`,`description`,`targetValue`,`isCompleted`,`completedTime`,`evidenceText`,`evidenceSource`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final ChronicPlanEntity entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getDate() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getDate());
        }
        final String _tmp = __chronicTypeConverters.fromDiseaseType(entity.getDiseaseType());
        if (_tmp == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, _tmp);
        }
        final String _tmp_1 = __chronicTypeConverters.fromPlanType(entity.getType());
        if (_tmp_1 == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, _tmp_1);
        }
        if (entity.getTitle() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getTitle());
        }
        if (entity.getDescription() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getDescription());
        }
        if (entity.getTargetValue() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getTargetValue());
        }
        final int _tmp_2 = entity.isCompleted() ? 1 : 0;
        statement.bindLong(8, _tmp_2);
        if (entity.getCompletedTime() == null) {
          statement.bindNull(9);
        } else {
          statement.bindLong(9, entity.getCompletedTime());
        }
        if (entity.getEvidenceText() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getEvidenceText());
        }
        if (entity.getEvidenceSource() == null) {
          statement.bindNull(11);
        } else {
          statement.bindString(11, entity.getEvidenceSource());
        }
      }
    };
    this.__updateAdapterOfChronicPlanEntity = new EntityDeletionOrUpdateAdapter<ChronicPlanEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `chronic_plans` SET `id` = ?,`date` = ?,`diseaseType` = ?,`type` = ?,`title` = ?,`description` = ?,`targetValue` = ?,`isCompleted` = ?,`completedTime` = ?,`evidenceText` = ?,`evidenceSource` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final ChronicPlanEntity entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getDate() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getDate());
        }
        final String _tmp = __chronicTypeConverters.fromDiseaseType(entity.getDiseaseType());
        if (_tmp == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, _tmp);
        }
        final String _tmp_1 = __chronicTypeConverters.fromPlanType(entity.getType());
        if (_tmp_1 == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, _tmp_1);
        }
        if (entity.getTitle() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getTitle());
        }
        if (entity.getDescription() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getDescription());
        }
        if (entity.getTargetValue() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getTargetValue());
        }
        final int _tmp_2 = entity.isCompleted() ? 1 : 0;
        statement.bindLong(8, _tmp_2);
        if (entity.getCompletedTime() == null) {
          statement.bindNull(9);
        } else {
          statement.bindLong(9, entity.getCompletedTime());
        }
        if (entity.getEvidenceText() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getEvidenceText());
        }
        if (entity.getEvidenceSource() == null) {
          statement.bindNull(11);
        } else {
          statement.bindString(11, entity.getEvidenceSource());
        }
        statement.bindLong(12, entity.getId());
      }
    };
    this.__preparedStmtOfClearPlans = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM chronic_plans WHERE date = ? AND diseaseType = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertRiskRecord(final ChronicRiskEntity record,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfChronicRiskEntity.insert(record);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertPlans(final List<ChronicPlanEntity> plans,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfChronicPlanEntity.insert(plans);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updatePlan(final ChronicPlanEntity plan,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfChronicPlanEntity.handle(plan);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object clearPlans(final String date, final ChronicDiseaseType type,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfClearPlans.acquire();
        int _argIndex = 1;
        if (date == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, date);
        }
        _argIndex = 2;
        final String _tmp = __chronicTypeConverters.fromDiseaseType(type);
        if (_tmp == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, _tmp);
        }
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfClearPlans.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<ChronicRiskEntity> getLatestRisk(final ChronicDiseaseType type) {
    final String _sql = "SELECT * FROM chronic_risk_records WHERE diseaseType = ? ORDER BY timestamp DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    final String _tmp = __chronicTypeConverters.fromDiseaseType(type);
    if (_tmp == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, _tmp);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"chronic_risk_records"}, new Callable<ChronicRiskEntity>() {
      @Override
      @Nullable
      public ChronicRiskEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final int _cursorIndexOfDiseaseType = CursorUtil.getColumnIndexOrThrow(_cursor, "diseaseType");
          final int _cursorIndexOfRiskLevel = CursorUtil.getColumnIndexOrThrow(_cursor, "riskLevel");
          final int _cursorIndexOfRiskScore = CursorUtil.getColumnIndexOrThrow(_cursor, "riskScore");
          final int _cursorIndexOfRiskFactorsJson = CursorUtil.getColumnIndexOrThrow(_cursor, "riskFactorsJson");
          final ChronicRiskEntity _result;
          if (_cursor.moveToFirst()) {
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            final ChronicDiseaseType _tmpDiseaseType;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfDiseaseType)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfDiseaseType);
            }
            _tmpDiseaseType = __chronicTypeConverters.toDiseaseType(_tmp_1);
            final RiskLevel _tmpRiskLevel;
            final String _tmp_2;
            if (_cursor.isNull(_cursorIndexOfRiskLevel)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getString(_cursorIndexOfRiskLevel);
            }
            _tmpRiskLevel = __chronicTypeConverters.toRiskLevel(_tmp_2);
            final int _tmpRiskScore;
            _tmpRiskScore = _cursor.getInt(_cursorIndexOfRiskScore);
            final String _tmpRiskFactorsJson;
            if (_cursor.isNull(_cursorIndexOfRiskFactorsJson)) {
              _tmpRiskFactorsJson = null;
            } else {
              _tmpRiskFactorsJson = _cursor.getString(_cursorIndexOfRiskFactorsJson);
            }
            _result = new ChronicRiskEntity(_tmpId,_tmpTimestamp,_tmpDiseaseType,_tmpRiskLevel,_tmpRiskScore,_tmpRiskFactorsJson);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object getRiskHistory(final ChronicDiseaseType type,
      final Continuation<? super List<ChronicRiskEntity>> $completion) {
    final String _sql = "SELECT * FROM chronic_risk_records WHERE diseaseType = ? ORDER BY timestamp DESC LIMIT 30";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    final String _tmp = __chronicTypeConverters.fromDiseaseType(type);
    if (_tmp == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, _tmp);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<ChronicRiskEntity>>() {
      @Override
      @NonNull
      public List<ChronicRiskEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final int _cursorIndexOfDiseaseType = CursorUtil.getColumnIndexOrThrow(_cursor, "diseaseType");
          final int _cursorIndexOfRiskLevel = CursorUtil.getColumnIndexOrThrow(_cursor, "riskLevel");
          final int _cursorIndexOfRiskScore = CursorUtil.getColumnIndexOrThrow(_cursor, "riskScore");
          final int _cursorIndexOfRiskFactorsJson = CursorUtil.getColumnIndexOrThrow(_cursor, "riskFactorsJson");
          final List<ChronicRiskEntity> _result = new ArrayList<ChronicRiskEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final ChronicRiskEntity _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            final ChronicDiseaseType _tmpDiseaseType;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfDiseaseType)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfDiseaseType);
            }
            _tmpDiseaseType = __chronicTypeConverters.toDiseaseType(_tmp_1);
            final RiskLevel _tmpRiskLevel;
            final String _tmp_2;
            if (_cursor.isNull(_cursorIndexOfRiskLevel)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getString(_cursorIndexOfRiskLevel);
            }
            _tmpRiskLevel = __chronicTypeConverters.toRiskLevel(_tmp_2);
            final int _tmpRiskScore;
            _tmpRiskScore = _cursor.getInt(_cursorIndexOfRiskScore);
            final String _tmpRiskFactorsJson;
            if (_cursor.isNull(_cursorIndexOfRiskFactorsJson)) {
              _tmpRiskFactorsJson = null;
            } else {
              _tmpRiskFactorsJson = _cursor.getString(_cursorIndexOfRiskFactorsJson);
            }
            _item = new ChronicRiskEntity(_tmpId,_tmpTimestamp,_tmpDiseaseType,_tmpRiskLevel,_tmpRiskScore,_tmpRiskFactorsJson);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<ChronicPlanEntity>> getPlansFlow(final String date,
      final ChronicDiseaseType type) {
    final String _sql = "SELECT * FROM chronic_plans WHERE date = ? AND diseaseType = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (date == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, date);
    }
    _argIndex = 2;
    final String _tmp = __chronicTypeConverters.fromDiseaseType(type);
    if (_tmp == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, _tmp);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"chronic_plans"}, new Callable<List<ChronicPlanEntity>>() {
      @Override
      @NonNull
      public List<ChronicPlanEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfDiseaseType = CursorUtil.getColumnIndexOrThrow(_cursor, "diseaseType");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfTargetValue = CursorUtil.getColumnIndexOrThrow(_cursor, "targetValue");
          final int _cursorIndexOfIsCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "isCompleted");
          final int _cursorIndexOfCompletedTime = CursorUtil.getColumnIndexOrThrow(_cursor, "completedTime");
          final int _cursorIndexOfEvidenceText = CursorUtil.getColumnIndexOrThrow(_cursor, "evidenceText");
          final int _cursorIndexOfEvidenceSource = CursorUtil.getColumnIndexOrThrow(_cursor, "evidenceSource");
          final List<ChronicPlanEntity> _result = new ArrayList<ChronicPlanEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final ChronicPlanEntity _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpDate;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmpDate = null;
            } else {
              _tmpDate = _cursor.getString(_cursorIndexOfDate);
            }
            final ChronicDiseaseType _tmpDiseaseType;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfDiseaseType)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfDiseaseType);
            }
            _tmpDiseaseType = __chronicTypeConverters.toDiseaseType(_tmp_1);
            final PlanType _tmpType;
            final String _tmp_2;
            if (_cursor.isNull(_cursorIndexOfType)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getString(_cursorIndexOfType);
            }
            _tmpType = __chronicTypeConverters.toPlanType(_tmp_2);
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpTargetValue;
            if (_cursor.isNull(_cursorIndexOfTargetValue)) {
              _tmpTargetValue = null;
            } else {
              _tmpTargetValue = _cursor.getString(_cursorIndexOfTargetValue);
            }
            final boolean _tmpIsCompleted;
            final int _tmp_3;
            _tmp_3 = _cursor.getInt(_cursorIndexOfIsCompleted);
            _tmpIsCompleted = _tmp_3 != 0;
            final Long _tmpCompletedTime;
            if (_cursor.isNull(_cursorIndexOfCompletedTime)) {
              _tmpCompletedTime = null;
            } else {
              _tmpCompletedTime = _cursor.getLong(_cursorIndexOfCompletedTime);
            }
            final String _tmpEvidenceText;
            if (_cursor.isNull(_cursorIndexOfEvidenceText)) {
              _tmpEvidenceText = null;
            } else {
              _tmpEvidenceText = _cursor.getString(_cursorIndexOfEvidenceText);
            }
            final String _tmpEvidenceSource;
            if (_cursor.isNull(_cursorIndexOfEvidenceSource)) {
              _tmpEvidenceSource = null;
            } else {
              _tmpEvidenceSource = _cursor.getString(_cursorIndexOfEvidenceSource);
            }
            _item = new ChronicPlanEntity(_tmpId,_tmpDate,_tmpDiseaseType,_tmpType,_tmpTitle,_tmpDescription,_tmpTargetValue,_tmpIsCompleted,_tmpCompletedTime,_tmpEvidenceText,_tmpEvidenceSource);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object getPlans(final String date, final ChronicDiseaseType type,
      final Continuation<? super List<ChronicPlanEntity>> $completion) {
    final String _sql = "SELECT * FROM chronic_plans WHERE date = ? AND diseaseType = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (date == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, date);
    }
    _argIndex = 2;
    final String _tmp = __chronicTypeConverters.fromDiseaseType(type);
    if (_tmp == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, _tmp);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<ChronicPlanEntity>>() {
      @Override
      @NonNull
      public List<ChronicPlanEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfDiseaseType = CursorUtil.getColumnIndexOrThrow(_cursor, "diseaseType");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfTargetValue = CursorUtil.getColumnIndexOrThrow(_cursor, "targetValue");
          final int _cursorIndexOfIsCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "isCompleted");
          final int _cursorIndexOfCompletedTime = CursorUtil.getColumnIndexOrThrow(_cursor, "completedTime");
          final int _cursorIndexOfEvidenceText = CursorUtil.getColumnIndexOrThrow(_cursor, "evidenceText");
          final int _cursorIndexOfEvidenceSource = CursorUtil.getColumnIndexOrThrow(_cursor, "evidenceSource");
          final List<ChronicPlanEntity> _result = new ArrayList<ChronicPlanEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final ChronicPlanEntity _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpDate;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmpDate = null;
            } else {
              _tmpDate = _cursor.getString(_cursorIndexOfDate);
            }
            final ChronicDiseaseType _tmpDiseaseType;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfDiseaseType)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfDiseaseType);
            }
            _tmpDiseaseType = __chronicTypeConverters.toDiseaseType(_tmp_1);
            final PlanType _tmpType;
            final String _tmp_2;
            if (_cursor.isNull(_cursorIndexOfType)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getString(_cursorIndexOfType);
            }
            _tmpType = __chronicTypeConverters.toPlanType(_tmp_2);
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpTargetValue;
            if (_cursor.isNull(_cursorIndexOfTargetValue)) {
              _tmpTargetValue = null;
            } else {
              _tmpTargetValue = _cursor.getString(_cursorIndexOfTargetValue);
            }
            final boolean _tmpIsCompleted;
            final int _tmp_3;
            _tmp_3 = _cursor.getInt(_cursorIndexOfIsCompleted);
            _tmpIsCompleted = _tmp_3 != 0;
            final Long _tmpCompletedTime;
            if (_cursor.isNull(_cursorIndexOfCompletedTime)) {
              _tmpCompletedTime = null;
            } else {
              _tmpCompletedTime = _cursor.getLong(_cursorIndexOfCompletedTime);
            }
            final String _tmpEvidenceText;
            if (_cursor.isNull(_cursorIndexOfEvidenceText)) {
              _tmpEvidenceText = null;
            } else {
              _tmpEvidenceText = _cursor.getString(_cursorIndexOfEvidenceText);
            }
            final String _tmpEvidenceSource;
            if (_cursor.isNull(_cursorIndexOfEvidenceSource)) {
              _tmpEvidenceSource = null;
            } else {
              _tmpEvidenceSource = _cursor.getString(_cursorIndexOfEvidenceSource);
            }
            _item = new ChronicPlanEntity(_tmpId,_tmpDate,_tmpDiseaseType,_tmpType,_tmpTitle,_tmpDescription,_tmpTargetValue,_tmpIsCompleted,_tmpCompletedTime,_tmpEvidenceText,_tmpEvidenceSource);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
