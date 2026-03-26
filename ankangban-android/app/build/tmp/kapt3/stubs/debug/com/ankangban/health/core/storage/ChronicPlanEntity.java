package com.ankangban.health.core.storage;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\'\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bq\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0012J\t\u0010&\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\'\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010)\u001a\u00020\u0005H\u00c6\u0003J\t\u0010*\u001a\u00020\u0007H\u00c6\u0003J\t\u0010+\u001a\u00020\tH\u00c6\u0003J\t\u0010,\u001a\u00020\u0005H\u00c6\u0003J\t\u0010-\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010/\u001a\u00020\u000eH\u00c6\u0003J\u0010\u00100\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0014J\u0084\u0001\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001\u00a2\u0006\u0002\u00102J\u0013\u00103\u001a\u00020\u000e2\b\u00104\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00105\u001a\u000206H\u00d6\u0001J\t\u00107\u001a\u00020\u0005H\u00d6\u0001R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u001f\"\u0004\b \u0010!R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017R\u0011\u0010\n\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0017R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010%\u00a8\u00068"}, d2 = {"Lcom/ankangban/health/core/storage/ChronicPlanEntity;", "", "id", "", "date", "", "diseaseType", "Lcom/ankangban/health/core/storage/ChronicDiseaseType;", "type", "Lcom/ankangban/health/core/storage/PlanType;", "title", "description", "targetValue", "isCompleted", "", "completedTime", "evidenceText", "evidenceSource", "(JLjava/lang/String;Lcom/ankangban/health/core/storage/ChronicDiseaseType;Lcom/ankangban/health/core/storage/PlanType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Long;Ljava/lang/String;Ljava/lang/String;)V", "getCompletedTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getDate", "()Ljava/lang/String;", "getDescription", "getDiseaseType", "()Lcom/ankangban/health/core/storage/ChronicDiseaseType;", "getEvidenceSource", "getEvidenceText", "getId", "()J", "()Z", "setCompleted", "(Z)V", "getTargetValue", "getTitle", "getType", "()Lcom/ankangban/health/core/storage/PlanType;", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(JLjava/lang/String;Lcom/ankangban/health/core/storage/ChronicDiseaseType;Lcom/ankangban/health/core/storage/PlanType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Long;Ljava/lang/String;Ljava/lang/String;)Lcom/ankangban/health/core/storage/ChronicPlanEntity;", "equals", "other", "hashCode", "", "toString", "app_debug"})
@androidx.room.Entity(tableName = "chronic_plans")
public final class ChronicPlanEntity {
    @androidx.room.PrimaryKey(autoGenerate = true)
    private final long id = 0L;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String date = null;
    @org.jetbrains.annotations.NotNull
    private final com.ankangban.health.core.storage.ChronicDiseaseType diseaseType = null;
    @org.jetbrains.annotations.NotNull
    private final com.ankangban.health.core.storage.PlanType type = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String title = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String description = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String targetValue = null;
    private boolean isCompleted;
    @org.jetbrains.annotations.Nullable
    private final java.lang.Long completedTime = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String evidenceText = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String evidenceSource = null;
    
    public ChronicPlanEntity(long id, @org.jetbrains.annotations.NotNull
    java.lang.String date, @org.jetbrains.annotations.NotNull
    com.ankangban.health.core.storage.ChronicDiseaseType diseaseType, @org.jetbrains.annotations.NotNull
    com.ankangban.health.core.storage.PlanType type, @org.jetbrains.annotations.NotNull
    java.lang.String title, @org.jetbrains.annotations.NotNull
    java.lang.String description, @org.jetbrains.annotations.Nullable
    java.lang.String targetValue, boolean isCompleted, @org.jetbrains.annotations.Nullable
    java.lang.Long completedTime, @org.jetbrains.annotations.Nullable
    java.lang.String evidenceText, @org.jetbrains.annotations.Nullable
    java.lang.String evidenceSource) {
        super();
    }
    
    public final long getId() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getDate() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.ankangban.health.core.storage.ChronicDiseaseType getDiseaseType() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.ankangban.health.core.storage.PlanType getType() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getTitle() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getDescription() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getTargetValue() {
        return null;
    }
    
    public final boolean isCompleted() {
        return false;
    }
    
    public final void setCompleted(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Long getCompletedTime() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getEvidenceText() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getEvidenceSource() {
        return null;
    }
    
    public final long component1() {
        return 0L;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component11() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.ankangban.health.core.storage.ChronicDiseaseType component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.ankangban.health.core.storage.PlanType component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component7() {
        return null;
    }
    
    public final boolean component8() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Long component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.ankangban.health.core.storage.ChronicPlanEntity copy(long id, @org.jetbrains.annotations.NotNull
    java.lang.String date, @org.jetbrains.annotations.NotNull
    com.ankangban.health.core.storage.ChronicDiseaseType diseaseType, @org.jetbrains.annotations.NotNull
    com.ankangban.health.core.storage.PlanType type, @org.jetbrains.annotations.NotNull
    java.lang.String title, @org.jetbrains.annotations.NotNull
    java.lang.String description, @org.jetbrains.annotations.Nullable
    java.lang.String targetValue, boolean isCompleted, @org.jetbrains.annotations.Nullable
    java.lang.Long completedTime, @org.jetbrains.annotations.Nullable
    java.lang.String evidenceText, @org.jetbrains.annotations.Nullable
    java.lang.String evidenceSource) {
        return null;
    }
    
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return null;
    }
}