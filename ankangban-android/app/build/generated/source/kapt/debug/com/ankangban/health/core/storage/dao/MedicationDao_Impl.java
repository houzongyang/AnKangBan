package com.ankangban.health.core.storage.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.RelationUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.ankangban.health.core.storage.entity.MedicationEntity;
import com.ankangban.health.core.storage.entity.ReminderEntity;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
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
public final class MedicationDao_Impl implements MedicationDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<MedicationEntity> __insertionAdapterOfMedicationEntity;

  private final EntityInsertionAdapter<ReminderEntity> __insertionAdapterOfReminderEntity;

  private final EntityDeletionOrUpdateAdapter<MedicationEntity> __deletionAdapterOfMedicationEntity;

  private final EntityDeletionOrUpdateAdapter<MedicationEntity> __updateAdapterOfMedicationEntity;

  private final SharedSQLiteStatement __preparedStmtOfDeleteRemindersByMedicationId;

  public MedicationDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfMedicationEntity = new EntityInsertionAdapter<MedicationEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `medications` (`id`,`name`,`dosage`,`frequency`,`total_stock`,`unit`,`image_uri`,`side_image_uri`,`create_time`,`ai_analysis_raw`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final MedicationEntity entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getName());
        }
        if (entity.getDosage() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getDosage());
        }
        if (entity.getFrequency() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getFrequency());
        }
        statement.bindLong(5, entity.getTotalStock());
        if (entity.getUnit() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getUnit());
        }
        if (entity.getImageUri() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getImageUri());
        }
        if (entity.getSideImageUri() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getSideImageUri());
        }
        statement.bindLong(9, entity.getCreateTime());
        if (entity.getAiAnalysisRaw() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getAiAnalysisRaw());
        }
      }
    };
    this.__insertionAdapterOfReminderEntity = new EntityInsertionAdapter<ReminderEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `reminders` (`id`,`medication_id`,`time_hour`,`time_minute`,`is_enabled`,`label`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final ReminderEntity entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getMedicationId());
        statement.bindLong(3, entity.getHour());
        statement.bindLong(4, entity.getMinute());
        final int _tmp = entity.isEnabled() ? 1 : 0;
        statement.bindLong(5, _tmp);
        if (entity.getLabel() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getLabel());
        }
      }
    };
    this.__deletionAdapterOfMedicationEntity = new EntityDeletionOrUpdateAdapter<MedicationEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `medications` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final MedicationEntity entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfMedicationEntity = new EntityDeletionOrUpdateAdapter<MedicationEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `medications` SET `id` = ?,`name` = ?,`dosage` = ?,`frequency` = ?,`total_stock` = ?,`unit` = ?,`image_uri` = ?,`side_image_uri` = ?,`create_time` = ?,`ai_analysis_raw` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final MedicationEntity entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getName());
        }
        if (entity.getDosage() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getDosage());
        }
        if (entity.getFrequency() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getFrequency());
        }
        statement.bindLong(5, entity.getTotalStock());
        if (entity.getUnit() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getUnit());
        }
        if (entity.getImageUri() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getImageUri());
        }
        if (entity.getSideImageUri() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getSideImageUri());
        }
        statement.bindLong(9, entity.getCreateTime());
        if (entity.getAiAnalysisRaw() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getAiAnalysisRaw());
        }
        statement.bindLong(11, entity.getId());
      }
    };
    this.__preparedStmtOfDeleteRemindersByMedicationId = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM reminders WHERE medication_id = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertMedication(final MedicationEntity medication,
      final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfMedicationEntity.insertAndReturnId(medication);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertReminders(final List<ReminderEntity> reminders,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfReminderEntity.insert(reminders);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteMedication(final MedicationEntity medication,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfMedicationEntity.handle(medication);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateMedication(final MedicationEntity medication,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfMedicationEntity.handle(medication);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteRemindersByMedicationId(final long medicationId,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteRemindersByMedicationId.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, medicationId);
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
          __preparedStmtOfDeleteRemindersByMedicationId.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<MedicationEntity>> getAllMedications() {
    final String _sql = "SELECT * FROM medications ORDER BY create_time DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"medications"}, new Callable<List<MedicationEntity>>() {
      @Override
      @NonNull
      public List<MedicationEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfDosage = CursorUtil.getColumnIndexOrThrow(_cursor, "dosage");
          final int _cursorIndexOfFrequency = CursorUtil.getColumnIndexOrThrow(_cursor, "frequency");
          final int _cursorIndexOfTotalStock = CursorUtil.getColumnIndexOrThrow(_cursor, "total_stock");
          final int _cursorIndexOfUnit = CursorUtil.getColumnIndexOrThrow(_cursor, "unit");
          final int _cursorIndexOfImageUri = CursorUtil.getColumnIndexOrThrow(_cursor, "image_uri");
          final int _cursorIndexOfSideImageUri = CursorUtil.getColumnIndexOrThrow(_cursor, "side_image_uri");
          final int _cursorIndexOfCreateTime = CursorUtil.getColumnIndexOrThrow(_cursor, "create_time");
          final int _cursorIndexOfAiAnalysisRaw = CursorUtil.getColumnIndexOrThrow(_cursor, "ai_analysis_raw");
          final List<MedicationEntity> _result = new ArrayList<MedicationEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final MedicationEntity _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpDosage;
            if (_cursor.isNull(_cursorIndexOfDosage)) {
              _tmpDosage = null;
            } else {
              _tmpDosage = _cursor.getString(_cursorIndexOfDosage);
            }
            final String _tmpFrequency;
            if (_cursor.isNull(_cursorIndexOfFrequency)) {
              _tmpFrequency = null;
            } else {
              _tmpFrequency = _cursor.getString(_cursorIndexOfFrequency);
            }
            final int _tmpTotalStock;
            _tmpTotalStock = _cursor.getInt(_cursorIndexOfTotalStock);
            final String _tmpUnit;
            if (_cursor.isNull(_cursorIndexOfUnit)) {
              _tmpUnit = null;
            } else {
              _tmpUnit = _cursor.getString(_cursorIndexOfUnit);
            }
            final String _tmpImageUri;
            if (_cursor.isNull(_cursorIndexOfImageUri)) {
              _tmpImageUri = null;
            } else {
              _tmpImageUri = _cursor.getString(_cursorIndexOfImageUri);
            }
            final String _tmpSideImageUri;
            if (_cursor.isNull(_cursorIndexOfSideImageUri)) {
              _tmpSideImageUri = null;
            } else {
              _tmpSideImageUri = _cursor.getString(_cursorIndexOfSideImageUri);
            }
            final long _tmpCreateTime;
            _tmpCreateTime = _cursor.getLong(_cursorIndexOfCreateTime);
            final String _tmpAiAnalysisRaw;
            if (_cursor.isNull(_cursorIndexOfAiAnalysisRaw)) {
              _tmpAiAnalysisRaw = null;
            } else {
              _tmpAiAnalysisRaw = _cursor.getString(_cursorIndexOfAiAnalysisRaw);
            }
            _item = new MedicationEntity(_tmpId,_tmpName,_tmpDosage,_tmpFrequency,_tmpTotalStock,_tmpUnit,_tmpImageUri,_tmpSideImageUri,_tmpCreateTime,_tmpAiAnalysisRaw);
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
  public Object getMedicationById(final long id,
      final Continuation<? super MedicationEntity> $completion) {
    final String _sql = "SELECT * FROM medications WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<MedicationEntity>() {
      @Override
      @Nullable
      public MedicationEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfDosage = CursorUtil.getColumnIndexOrThrow(_cursor, "dosage");
          final int _cursorIndexOfFrequency = CursorUtil.getColumnIndexOrThrow(_cursor, "frequency");
          final int _cursorIndexOfTotalStock = CursorUtil.getColumnIndexOrThrow(_cursor, "total_stock");
          final int _cursorIndexOfUnit = CursorUtil.getColumnIndexOrThrow(_cursor, "unit");
          final int _cursorIndexOfImageUri = CursorUtil.getColumnIndexOrThrow(_cursor, "image_uri");
          final int _cursorIndexOfSideImageUri = CursorUtil.getColumnIndexOrThrow(_cursor, "side_image_uri");
          final int _cursorIndexOfCreateTime = CursorUtil.getColumnIndexOrThrow(_cursor, "create_time");
          final int _cursorIndexOfAiAnalysisRaw = CursorUtil.getColumnIndexOrThrow(_cursor, "ai_analysis_raw");
          final MedicationEntity _result;
          if (_cursor.moveToFirst()) {
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpDosage;
            if (_cursor.isNull(_cursorIndexOfDosage)) {
              _tmpDosage = null;
            } else {
              _tmpDosage = _cursor.getString(_cursorIndexOfDosage);
            }
            final String _tmpFrequency;
            if (_cursor.isNull(_cursorIndexOfFrequency)) {
              _tmpFrequency = null;
            } else {
              _tmpFrequency = _cursor.getString(_cursorIndexOfFrequency);
            }
            final int _tmpTotalStock;
            _tmpTotalStock = _cursor.getInt(_cursorIndexOfTotalStock);
            final String _tmpUnit;
            if (_cursor.isNull(_cursorIndexOfUnit)) {
              _tmpUnit = null;
            } else {
              _tmpUnit = _cursor.getString(_cursorIndexOfUnit);
            }
            final String _tmpImageUri;
            if (_cursor.isNull(_cursorIndexOfImageUri)) {
              _tmpImageUri = null;
            } else {
              _tmpImageUri = _cursor.getString(_cursorIndexOfImageUri);
            }
            final String _tmpSideImageUri;
            if (_cursor.isNull(_cursorIndexOfSideImageUri)) {
              _tmpSideImageUri = null;
            } else {
              _tmpSideImageUri = _cursor.getString(_cursorIndexOfSideImageUri);
            }
            final long _tmpCreateTime;
            _tmpCreateTime = _cursor.getLong(_cursorIndexOfCreateTime);
            final String _tmpAiAnalysisRaw;
            if (_cursor.isNull(_cursorIndexOfAiAnalysisRaw)) {
              _tmpAiAnalysisRaw = null;
            } else {
              _tmpAiAnalysisRaw = _cursor.getString(_cursorIndexOfAiAnalysisRaw);
            }
            _result = new MedicationEntity(_tmpId,_tmpName,_tmpDosage,_tmpFrequency,_tmpTotalStock,_tmpUnit,_tmpImageUri,_tmpSideImageUri,_tmpCreateTime,_tmpAiAnalysisRaw);
          } else {
            _result = null;
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
  public Flow<List<ReminderEntity>> getRemindersForMedication(final long medicationId) {
    final String _sql = "SELECT * FROM reminders WHERE medication_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, medicationId);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"reminders"}, new Callable<List<ReminderEntity>>() {
      @Override
      @NonNull
      public List<ReminderEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfMedicationId = CursorUtil.getColumnIndexOrThrow(_cursor, "medication_id");
          final int _cursorIndexOfHour = CursorUtil.getColumnIndexOrThrow(_cursor, "time_hour");
          final int _cursorIndexOfMinute = CursorUtil.getColumnIndexOrThrow(_cursor, "time_minute");
          final int _cursorIndexOfIsEnabled = CursorUtil.getColumnIndexOrThrow(_cursor, "is_enabled");
          final int _cursorIndexOfLabel = CursorUtil.getColumnIndexOrThrow(_cursor, "label");
          final List<ReminderEntity> _result = new ArrayList<ReminderEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final ReminderEntity _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final long _tmpMedicationId;
            _tmpMedicationId = _cursor.getLong(_cursorIndexOfMedicationId);
            final int _tmpHour;
            _tmpHour = _cursor.getInt(_cursorIndexOfHour);
            final int _tmpMinute;
            _tmpMinute = _cursor.getInt(_cursorIndexOfMinute);
            final boolean _tmpIsEnabled;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsEnabled);
            _tmpIsEnabled = _tmp != 0;
            final String _tmpLabel;
            if (_cursor.isNull(_cursorIndexOfLabel)) {
              _tmpLabel = null;
            } else {
              _tmpLabel = _cursor.getString(_cursorIndexOfLabel);
            }
            _item = new ReminderEntity(_tmpId,_tmpMedicationId,_tmpHour,_tmpMinute,_tmpIsEnabled,_tmpLabel);
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
  public Object getAllActiveReminders(
      final Continuation<? super List<ReminderEntity>> $completion) {
    final String _sql = "SELECT * FROM reminders WHERE is_enabled = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<ReminderEntity>>() {
      @Override
      @NonNull
      public List<ReminderEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfMedicationId = CursorUtil.getColumnIndexOrThrow(_cursor, "medication_id");
          final int _cursorIndexOfHour = CursorUtil.getColumnIndexOrThrow(_cursor, "time_hour");
          final int _cursorIndexOfMinute = CursorUtil.getColumnIndexOrThrow(_cursor, "time_minute");
          final int _cursorIndexOfIsEnabled = CursorUtil.getColumnIndexOrThrow(_cursor, "is_enabled");
          final int _cursorIndexOfLabel = CursorUtil.getColumnIndexOrThrow(_cursor, "label");
          final List<ReminderEntity> _result = new ArrayList<ReminderEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final ReminderEntity _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final long _tmpMedicationId;
            _tmpMedicationId = _cursor.getLong(_cursorIndexOfMedicationId);
            final int _tmpHour;
            _tmpHour = _cursor.getInt(_cursorIndexOfHour);
            final int _tmpMinute;
            _tmpMinute = _cursor.getInt(_cursorIndexOfMinute);
            final boolean _tmpIsEnabled;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsEnabled);
            _tmpIsEnabled = _tmp != 0;
            final String _tmpLabel;
            if (_cursor.isNull(_cursorIndexOfLabel)) {
              _tmpLabel = null;
            } else {
              _tmpLabel = _cursor.getString(_cursorIndexOfLabel);
            }
            _item = new ReminderEntity(_tmpId,_tmpMedicationId,_tmpHour,_tmpMinute,_tmpIsEnabled,_tmpLabel);
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
  public Flow<List<MedicationDao.MedicationWithReminders>> getMedicationsWithReminders() {
    final String _sql = "SELECT * FROM medications ORDER BY create_time DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, true, new String[] {"reminders",
        "medications"}, new Callable<List<MedicationDao.MedicationWithReminders>>() {
      @Override
      @NonNull
      public List<MedicationDao.MedicationWithReminders> call() throws Exception {
        __db.beginTransaction();
        try {
          final Cursor _cursor = DBUtil.query(__db, _statement, true, null);
          try {
            final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
            final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
            final int _cursorIndexOfDosage = CursorUtil.getColumnIndexOrThrow(_cursor, "dosage");
            final int _cursorIndexOfFrequency = CursorUtil.getColumnIndexOrThrow(_cursor, "frequency");
            final int _cursorIndexOfTotalStock = CursorUtil.getColumnIndexOrThrow(_cursor, "total_stock");
            final int _cursorIndexOfUnit = CursorUtil.getColumnIndexOrThrow(_cursor, "unit");
            final int _cursorIndexOfImageUri = CursorUtil.getColumnIndexOrThrow(_cursor, "image_uri");
            final int _cursorIndexOfSideImageUri = CursorUtil.getColumnIndexOrThrow(_cursor, "side_image_uri");
            final int _cursorIndexOfCreateTime = CursorUtil.getColumnIndexOrThrow(_cursor, "create_time");
            final int _cursorIndexOfAiAnalysisRaw = CursorUtil.getColumnIndexOrThrow(_cursor, "ai_analysis_raw");
            final LongSparseArray<ArrayList<ReminderEntity>> _collectionReminders = new LongSparseArray<ArrayList<ReminderEntity>>();
            while (_cursor.moveToNext()) {
              final long _tmpKey;
              _tmpKey = _cursor.getLong(_cursorIndexOfId);
              if (!_collectionReminders.containsKey(_tmpKey)) {
                _collectionReminders.put(_tmpKey, new ArrayList<ReminderEntity>());
              }
            }
            _cursor.moveToPosition(-1);
            __fetchRelationshipremindersAscomAnkangbanHealthCoreStorageEntityReminderEntity(_collectionReminders);
            final List<MedicationDao.MedicationWithReminders> _result = new ArrayList<MedicationDao.MedicationWithReminders>(_cursor.getCount());
            while (_cursor.moveToNext()) {
              final MedicationDao.MedicationWithReminders _item;
              final MedicationEntity _tmpMedication;
              final long _tmpId;
              _tmpId = _cursor.getLong(_cursorIndexOfId);
              final String _tmpName;
              if (_cursor.isNull(_cursorIndexOfName)) {
                _tmpName = null;
              } else {
                _tmpName = _cursor.getString(_cursorIndexOfName);
              }
              final String _tmpDosage;
              if (_cursor.isNull(_cursorIndexOfDosage)) {
                _tmpDosage = null;
              } else {
                _tmpDosage = _cursor.getString(_cursorIndexOfDosage);
              }
              final String _tmpFrequency;
              if (_cursor.isNull(_cursorIndexOfFrequency)) {
                _tmpFrequency = null;
              } else {
                _tmpFrequency = _cursor.getString(_cursorIndexOfFrequency);
              }
              final int _tmpTotalStock;
              _tmpTotalStock = _cursor.getInt(_cursorIndexOfTotalStock);
              final String _tmpUnit;
              if (_cursor.isNull(_cursorIndexOfUnit)) {
                _tmpUnit = null;
              } else {
                _tmpUnit = _cursor.getString(_cursorIndexOfUnit);
              }
              final String _tmpImageUri;
              if (_cursor.isNull(_cursorIndexOfImageUri)) {
                _tmpImageUri = null;
              } else {
                _tmpImageUri = _cursor.getString(_cursorIndexOfImageUri);
              }
              final String _tmpSideImageUri;
              if (_cursor.isNull(_cursorIndexOfSideImageUri)) {
                _tmpSideImageUri = null;
              } else {
                _tmpSideImageUri = _cursor.getString(_cursorIndexOfSideImageUri);
              }
              final long _tmpCreateTime;
              _tmpCreateTime = _cursor.getLong(_cursorIndexOfCreateTime);
              final String _tmpAiAnalysisRaw;
              if (_cursor.isNull(_cursorIndexOfAiAnalysisRaw)) {
                _tmpAiAnalysisRaw = null;
              } else {
                _tmpAiAnalysisRaw = _cursor.getString(_cursorIndexOfAiAnalysisRaw);
              }
              _tmpMedication = new MedicationEntity(_tmpId,_tmpName,_tmpDosage,_tmpFrequency,_tmpTotalStock,_tmpUnit,_tmpImageUri,_tmpSideImageUri,_tmpCreateTime,_tmpAiAnalysisRaw);
              final ArrayList<ReminderEntity> _tmpRemindersCollection;
              final long _tmpKey_1;
              _tmpKey_1 = _cursor.getLong(_cursorIndexOfId);
              _tmpRemindersCollection = _collectionReminders.get(_tmpKey_1);
              _item = new MedicationDao.MedicationWithReminders(_tmpMedication,_tmpRemindersCollection);
              _result.add(_item);
            }
            __db.setTransactionSuccessful();
            return _result;
          } finally {
            _cursor.close();
          }
        } finally {
          __db.endTransaction();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object getMedicationWithRemindersById(final long id,
      final Continuation<? super MedicationDao.MedicationWithReminders> $completion) {
    final String _sql = "SELECT * FROM medications WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, true, _cancellationSignal, new Callable<MedicationDao.MedicationWithReminders>() {
      @Override
      @Nullable
      public MedicationDao.MedicationWithReminders call() throws Exception {
        __db.beginTransaction();
        try {
          final Cursor _cursor = DBUtil.query(__db, _statement, true, null);
          try {
            final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
            final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
            final int _cursorIndexOfDosage = CursorUtil.getColumnIndexOrThrow(_cursor, "dosage");
            final int _cursorIndexOfFrequency = CursorUtil.getColumnIndexOrThrow(_cursor, "frequency");
            final int _cursorIndexOfTotalStock = CursorUtil.getColumnIndexOrThrow(_cursor, "total_stock");
            final int _cursorIndexOfUnit = CursorUtil.getColumnIndexOrThrow(_cursor, "unit");
            final int _cursorIndexOfImageUri = CursorUtil.getColumnIndexOrThrow(_cursor, "image_uri");
            final int _cursorIndexOfSideImageUri = CursorUtil.getColumnIndexOrThrow(_cursor, "side_image_uri");
            final int _cursorIndexOfCreateTime = CursorUtil.getColumnIndexOrThrow(_cursor, "create_time");
            final int _cursorIndexOfAiAnalysisRaw = CursorUtil.getColumnIndexOrThrow(_cursor, "ai_analysis_raw");
            final LongSparseArray<ArrayList<ReminderEntity>> _collectionReminders = new LongSparseArray<ArrayList<ReminderEntity>>();
            while (_cursor.moveToNext()) {
              final long _tmpKey;
              _tmpKey = _cursor.getLong(_cursorIndexOfId);
              if (!_collectionReminders.containsKey(_tmpKey)) {
                _collectionReminders.put(_tmpKey, new ArrayList<ReminderEntity>());
              }
            }
            _cursor.moveToPosition(-1);
            __fetchRelationshipremindersAscomAnkangbanHealthCoreStorageEntityReminderEntity(_collectionReminders);
            final MedicationDao.MedicationWithReminders _result;
            if (_cursor.moveToFirst()) {
              final MedicationEntity _tmpMedication;
              final long _tmpId;
              _tmpId = _cursor.getLong(_cursorIndexOfId);
              final String _tmpName;
              if (_cursor.isNull(_cursorIndexOfName)) {
                _tmpName = null;
              } else {
                _tmpName = _cursor.getString(_cursorIndexOfName);
              }
              final String _tmpDosage;
              if (_cursor.isNull(_cursorIndexOfDosage)) {
                _tmpDosage = null;
              } else {
                _tmpDosage = _cursor.getString(_cursorIndexOfDosage);
              }
              final String _tmpFrequency;
              if (_cursor.isNull(_cursorIndexOfFrequency)) {
                _tmpFrequency = null;
              } else {
                _tmpFrequency = _cursor.getString(_cursorIndexOfFrequency);
              }
              final int _tmpTotalStock;
              _tmpTotalStock = _cursor.getInt(_cursorIndexOfTotalStock);
              final String _tmpUnit;
              if (_cursor.isNull(_cursorIndexOfUnit)) {
                _tmpUnit = null;
              } else {
                _tmpUnit = _cursor.getString(_cursorIndexOfUnit);
              }
              final String _tmpImageUri;
              if (_cursor.isNull(_cursorIndexOfImageUri)) {
                _tmpImageUri = null;
              } else {
                _tmpImageUri = _cursor.getString(_cursorIndexOfImageUri);
              }
              final String _tmpSideImageUri;
              if (_cursor.isNull(_cursorIndexOfSideImageUri)) {
                _tmpSideImageUri = null;
              } else {
                _tmpSideImageUri = _cursor.getString(_cursorIndexOfSideImageUri);
              }
              final long _tmpCreateTime;
              _tmpCreateTime = _cursor.getLong(_cursorIndexOfCreateTime);
              final String _tmpAiAnalysisRaw;
              if (_cursor.isNull(_cursorIndexOfAiAnalysisRaw)) {
                _tmpAiAnalysisRaw = null;
              } else {
                _tmpAiAnalysisRaw = _cursor.getString(_cursorIndexOfAiAnalysisRaw);
              }
              _tmpMedication = new MedicationEntity(_tmpId,_tmpName,_tmpDosage,_tmpFrequency,_tmpTotalStock,_tmpUnit,_tmpImageUri,_tmpSideImageUri,_tmpCreateTime,_tmpAiAnalysisRaw);
              final ArrayList<ReminderEntity> _tmpRemindersCollection;
              final long _tmpKey_1;
              _tmpKey_1 = _cursor.getLong(_cursorIndexOfId);
              _tmpRemindersCollection = _collectionReminders.get(_tmpKey_1);
              _result = new MedicationDao.MedicationWithReminders(_tmpMedication,_tmpRemindersCollection);
            } else {
              _result = null;
            }
            __db.setTransactionSuccessful();
            return _result;
          } finally {
            _cursor.close();
            _statement.release();
          }
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }

  private void __fetchRelationshipremindersAscomAnkangbanHealthCoreStorageEntityReminderEntity(
      @NonNull final LongSparseArray<ArrayList<ReminderEntity>> _map) {
    if (_map.isEmpty()) {
      return;
    }
    if (_map.size() > RoomDatabase.MAX_BIND_PARAMETER_CNT) {
      RelationUtil.recursiveFetchLongSparseArray(_map, true, (map) -> {
        __fetchRelationshipremindersAscomAnkangbanHealthCoreStorageEntityReminderEntity(map);
        return Unit.INSTANCE;
      });
      return;
    }
    final StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT `id`,`medication_id`,`time_hour`,`time_minute`,`is_enabled`,`label` FROM `reminders` WHERE `medication_id` IN (");
    final int _inputSize = _map.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 0 + _inputSize;
    final RoomSQLiteQuery _stmt = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    for (int i = 0; i < _map.size(); i++) {
      final long _item = _map.keyAt(i);
      _stmt.bindLong(_argIndex, _item);
      _argIndex++;
    }
    final Cursor _cursor = DBUtil.query(__db, _stmt, false, null);
    try {
      final int _itemKeyIndex = CursorUtil.getColumnIndex(_cursor, "medication_id");
      if (_itemKeyIndex == -1) {
        return;
      }
      final int _cursorIndexOfId = 0;
      final int _cursorIndexOfMedicationId = 1;
      final int _cursorIndexOfHour = 2;
      final int _cursorIndexOfMinute = 3;
      final int _cursorIndexOfIsEnabled = 4;
      final int _cursorIndexOfLabel = 5;
      while (_cursor.moveToNext()) {
        final long _tmpKey;
        _tmpKey = _cursor.getLong(_itemKeyIndex);
        final ArrayList<ReminderEntity> _tmpRelation = _map.get(_tmpKey);
        if (_tmpRelation != null) {
          final ReminderEntity _item_1;
          final long _tmpId;
          _tmpId = _cursor.getLong(_cursorIndexOfId);
          final long _tmpMedicationId;
          _tmpMedicationId = _cursor.getLong(_cursorIndexOfMedicationId);
          final int _tmpHour;
          _tmpHour = _cursor.getInt(_cursorIndexOfHour);
          final int _tmpMinute;
          _tmpMinute = _cursor.getInt(_cursorIndexOfMinute);
          final boolean _tmpIsEnabled;
          final int _tmp;
          _tmp = _cursor.getInt(_cursorIndexOfIsEnabled);
          _tmpIsEnabled = _tmp != 0;
          final String _tmpLabel;
          if (_cursor.isNull(_cursorIndexOfLabel)) {
            _tmpLabel = null;
          } else {
            _tmpLabel = _cursor.getString(_cursorIndexOfLabel);
          }
          _item_1 = new ReminderEntity(_tmpId,_tmpMedicationId,_tmpHour,_tmpMinute,_tmpIsEnabled,_tmpLabel);
          _tmpRelation.add(_item_1);
        }
      }
    } finally {
      _cursor.close();
    }
  }
}
