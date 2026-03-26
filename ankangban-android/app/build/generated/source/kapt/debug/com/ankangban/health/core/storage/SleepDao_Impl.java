package com.ankangban.health.core.storage;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
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
public final class SleepDao_Impl implements SleepDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<SleepDataEntity> __insertionAdapterOfSleepDataEntity;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public SleepDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfSleepDataEntity = new EntityInsertionAdapter<SleepDataEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `sleep_data` (`id`,`totalMinutes`,`deepMinutes`,`lightMinutes`,`remMinutes`,`efficiency`,`startTime`,`endTime`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final SleepDataEntity entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getTotalMinutes());
        statement.bindLong(3, entity.getDeepMinutes());
        statement.bindLong(4, entity.getLightMinutes());
        statement.bindLong(5, entity.getRemMinutes());
        statement.bindDouble(6, entity.getEfficiency());
        statement.bindLong(7, entity.getStartTime());
        statement.bindLong(8, entity.getEndTime());
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM sleep_data";
        return _query;
      }
    };
  }

  @Override
  public Object insert(final SleepDataEntity data, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfSleepDataEntity.insert(data);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertAll(final List<SleepDataEntity> data,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfSleepDataEntity.insert(data);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteAll(final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
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
          __preparedStmtOfDeleteAll.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<SleepDataEntity> getLatest() {
    final String _sql = "SELECT * FROM sleep_data ORDER BY endTime DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"sleep_data"}, new Callable<SleepDataEntity>() {
      @Override
      @Nullable
      public SleepDataEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTotalMinutes = CursorUtil.getColumnIndexOrThrow(_cursor, "totalMinutes");
          final int _cursorIndexOfDeepMinutes = CursorUtil.getColumnIndexOrThrow(_cursor, "deepMinutes");
          final int _cursorIndexOfLightMinutes = CursorUtil.getColumnIndexOrThrow(_cursor, "lightMinutes");
          final int _cursorIndexOfRemMinutes = CursorUtil.getColumnIndexOrThrow(_cursor, "remMinutes");
          final int _cursorIndexOfEfficiency = CursorUtil.getColumnIndexOrThrow(_cursor, "efficiency");
          final int _cursorIndexOfStartTime = CursorUtil.getColumnIndexOrThrow(_cursor, "startTime");
          final int _cursorIndexOfEndTime = CursorUtil.getColumnIndexOrThrow(_cursor, "endTime");
          final SleepDataEntity _result;
          if (_cursor.moveToFirst()) {
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final int _tmpTotalMinutes;
            _tmpTotalMinutes = _cursor.getInt(_cursorIndexOfTotalMinutes);
            final int _tmpDeepMinutes;
            _tmpDeepMinutes = _cursor.getInt(_cursorIndexOfDeepMinutes);
            final int _tmpLightMinutes;
            _tmpLightMinutes = _cursor.getInt(_cursorIndexOfLightMinutes);
            final int _tmpRemMinutes;
            _tmpRemMinutes = _cursor.getInt(_cursorIndexOfRemMinutes);
            final float _tmpEfficiency;
            _tmpEfficiency = _cursor.getFloat(_cursorIndexOfEfficiency);
            final long _tmpStartTime;
            _tmpStartTime = _cursor.getLong(_cursorIndexOfStartTime);
            final long _tmpEndTime;
            _tmpEndTime = _cursor.getLong(_cursorIndexOfEndTime);
            _result = new SleepDataEntity(_tmpId,_tmpTotalMinutes,_tmpDeepMinutes,_tmpLightMinutes,_tmpRemMinutes,_tmpEfficiency,_tmpStartTime,_tmpEndTime);
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
  public Flow<List<SleepDataEntity>> getHistory(final long start, final long end) {
    final String _sql = "SELECT * FROM sleep_data WHERE startTime >= ? AND endTime <= ? ORDER BY startTime ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, start);
    _argIndex = 2;
    _statement.bindLong(_argIndex, end);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"sleep_data"}, new Callable<List<SleepDataEntity>>() {
      @Override
      @NonNull
      public List<SleepDataEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTotalMinutes = CursorUtil.getColumnIndexOrThrow(_cursor, "totalMinutes");
          final int _cursorIndexOfDeepMinutes = CursorUtil.getColumnIndexOrThrow(_cursor, "deepMinutes");
          final int _cursorIndexOfLightMinutes = CursorUtil.getColumnIndexOrThrow(_cursor, "lightMinutes");
          final int _cursorIndexOfRemMinutes = CursorUtil.getColumnIndexOrThrow(_cursor, "remMinutes");
          final int _cursorIndexOfEfficiency = CursorUtil.getColumnIndexOrThrow(_cursor, "efficiency");
          final int _cursorIndexOfStartTime = CursorUtil.getColumnIndexOrThrow(_cursor, "startTime");
          final int _cursorIndexOfEndTime = CursorUtil.getColumnIndexOrThrow(_cursor, "endTime");
          final List<SleepDataEntity> _result = new ArrayList<SleepDataEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final SleepDataEntity _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final int _tmpTotalMinutes;
            _tmpTotalMinutes = _cursor.getInt(_cursorIndexOfTotalMinutes);
            final int _tmpDeepMinutes;
            _tmpDeepMinutes = _cursor.getInt(_cursorIndexOfDeepMinutes);
            final int _tmpLightMinutes;
            _tmpLightMinutes = _cursor.getInt(_cursorIndexOfLightMinutes);
            final int _tmpRemMinutes;
            _tmpRemMinutes = _cursor.getInt(_cursorIndexOfRemMinutes);
            final float _tmpEfficiency;
            _tmpEfficiency = _cursor.getFloat(_cursorIndexOfEfficiency);
            final long _tmpStartTime;
            _tmpStartTime = _cursor.getLong(_cursorIndexOfStartTime);
            final long _tmpEndTime;
            _tmpEndTime = _cursor.getLong(_cursorIndexOfEndTime);
            _item = new SleepDataEntity(_tmpId,_tmpTotalMinutes,_tmpDeepMinutes,_tmpLightMinutes,_tmpRemMinutes,_tmpEfficiency,_tmpStartTime,_tmpEndTime);
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
