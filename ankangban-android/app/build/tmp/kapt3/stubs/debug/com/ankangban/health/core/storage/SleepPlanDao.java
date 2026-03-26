package com.ankangban.health.core.storage;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J\u001b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ$\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000e0\r2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\'J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J!\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0018\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0019"}, d2 = {"Lcom/ankangban/health/core/storage/SleepPlanDao;", "", "getCompletedCount", "", "startDate", "", "endDate", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPlanByDate", "Lcom/ankangban/health/core/storage/SleepPlanEntity;", "date", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPlansFlow", "Lkotlinx/coroutines/flow/Flow;", "", "insertPlan", "", "plan", "(Lcom/ankangban/health/core/storage/SleepPlanEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateCompletion", "id", "", "completed", "", "(JZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao
public abstract interface SleepPlanDao {
    
    @androidx.room.Query(value = "SELECT * FROM sleep_plans WHERE date = :date")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getPlanByDate(@org.jetbrains.annotations.NotNull
    java.lang.String date, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.ankangban.health.core.storage.SleepPlanEntity> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM sleep_plans WHERE date >= :startDate AND date <= :endDate ORDER BY date ASC")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.ankangban.health.core.storage.SleepPlanEntity>> getPlansFlow(@org.jetbrains.annotations.NotNull
    java.lang.String startDate, @org.jetbrains.annotations.NotNull
    java.lang.String endDate);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertPlan(@org.jetbrains.annotations.NotNull
    com.ankangban.health.core.storage.SleepPlanEntity plan, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE sleep_plans SET isCompleted = :completed WHERE id = :id")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateCompletion(long id, boolean completed, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM sleep_plans WHERE date >= :startDate AND date <= :endDate AND isCompleted = 1")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getCompletedCount(@org.jetbrains.annotations.NotNull
    java.lang.String startDate, @org.jetbrains.annotations.NotNull
    java.lang.String endDate, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
}