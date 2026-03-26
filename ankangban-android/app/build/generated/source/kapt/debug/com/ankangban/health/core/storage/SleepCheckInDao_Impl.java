package com.ankangban.health.core.storage;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
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
public final class SleepCheckInDao_Impl implements SleepCheckInDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<SleepCheckInEntity> __insertionAdapterOfSleepCheckInEntity;

  public SleepCheckInDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfSleepCheckInEntity = new EntityInsertionAdapter<SleepCheckInEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `sleep_checkins` (`id`,`date`,`qualityLevel`,`timestamp`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final SleepCheckInEntity entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getDate() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getDate());
        }
        if (entity.getQualityLevel() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getQualityLevel());
        }
        statement.bindLong(4, entity.getTimestamp());
      }
    };
  }

  @Override
  public Object insertCheckIn(final SleepCheckInEntity checkIn,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfSleepCheckInEntity.insert(checkIn);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object getCheckInByDate(final String date,
      final Continuation<? super SleepCheckInEntity> $completion) {
    final String _sql = "SELECT * FROM sleep_checkins WHERE date = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (date == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, date);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<SleepCheckInEntity>() {
      @Override
      @Nullable
      public SleepCheckInEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfQualityLevel = CursorUtil.getColumnIndexOrThrow(_cursor, "qualityLevel");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final SleepCheckInEntity _result;
          if (_cursor.moveToFirst()) {
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpDate;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmpDate = null;
            } else {
              _tmpDate = _cursor.getString(_cursorIndexOfDate);
            }
            final String _tmpQualityLevel;
            if (_cursor.isNull(_cursorIndexOfQualityLevel)) {
              _tmpQualityLevel = null;
            } else {
              _tmpQualityLevel = _cursor.getString(_cursorIndexOfQualityLevel);
            }
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            _result = new SleepCheckInEntity(_tmpId,_tmpDate,_tmpQualityLevel,_tmpTimestamp);
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
  public Flow<List<SleepCheckInEntity>> getCheckInsFlow(final String startDate,
      final String endDate) {
    final String _sql = "SELECT * FROM sleep_checkins WHERE date >= ? AND date <= ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (startDate == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, startDate);
    }
    _argIndex = 2;
    if (endDate == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, endDate);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"sleep_checkins"}, new Callable<List<SleepCheckInEntity>>() {
      @Override
      @NonNull
      public List<SleepCheckInEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfQualityLevel = CursorUtil.getColumnIndexOrThrow(_cursor, "qualityLevel");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final List<SleepCheckInEntity> _result = new ArrayList<SleepCheckInEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final SleepCheckInEntity _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpDate;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmpDate = null;
            } else {
              _tmpDate = _cursor.getString(_cursorIndexOfDate);
            }
            final String _tmpQualityLevel;
            if (_cursor.isNull(_cursorIndexOfQualityLevel)) {
              _tmpQualityLevel = null;
            } else {
              _tmpQualityLevel = _cursor.getString(_cursorIndexOfQualityLevel);
            }
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            _item = new SleepCheckInEntity(_tmpId,_tmpDate,_tmpQualityLevel,_tmpTimestamp);
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

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
