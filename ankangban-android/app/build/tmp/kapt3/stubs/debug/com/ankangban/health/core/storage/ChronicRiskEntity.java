package com.ankangban.health.core.storage;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\bH\u00c6\u0003J\t\u0010\u001d\u001a\u00020\nH\u00c6\u0003J\t\u0010\u001e\u001a\u00020\fH\u00c6\u0003JE\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u00c6\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010#\u001a\u00020\nH\u00d6\u0001J\t\u0010$\u001a\u00020\fH\u00d6\u0001R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011\u00a8\u0006%"}, d2 = {"Lcom/ankangban/health/core/storage/ChronicRiskEntity;", "", "id", "", "timestamp", "diseaseType", "Lcom/ankangban/health/core/storage/ChronicDiseaseType;", "riskLevel", "Lcom/ankangban/health/core/storage/RiskLevel;", "riskScore", "", "riskFactorsJson", "", "(JJLcom/ankangban/health/core/storage/ChronicDiseaseType;Lcom/ankangban/health/core/storage/RiskLevel;ILjava/lang/String;)V", "getDiseaseType", "()Lcom/ankangban/health/core/storage/ChronicDiseaseType;", "getId", "()J", "getRiskFactorsJson", "()Ljava/lang/String;", "getRiskLevel", "()Lcom/ankangban/health/core/storage/RiskLevel;", "getRiskScore", "()I", "getTimestamp", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"})
@androidx.room.Entity(tableName = "chronic_risk_records")
public final class ChronicRiskEntity {
    @androidx.room.PrimaryKey(autoGenerate = true)
    private final long id = 0L;
    private final long timestamp = 0L;
    @org.jetbrains.annotations.NotNull
    private final com.ankangban.health.core.storage.ChronicDiseaseType diseaseType = null;
    @org.jetbrains.annotations.NotNull
    private final com.ankangban.health.core.storage.RiskLevel riskLevel = null;
    private final int riskScore = 0;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String riskFactorsJson = null;
    
    public ChronicRiskEntity(long id, long timestamp, @org.jetbrains.annotations.NotNull
    com.ankangban.health.core.storage.ChronicDiseaseType diseaseType, @org.jetbrains.annotations.NotNull
    com.ankangban.health.core.storage.RiskLevel riskLevel, int riskScore, @org.jetbrains.annotations.NotNull
    java.lang.String riskFactorsJson) {
        super();
    }
    
    public final long getId() {
        return 0L;
    }
    
    public final long getTimestamp() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.ankangban.health.core.storage.ChronicDiseaseType getDiseaseType() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.ankangban.health.core.storage.RiskLevel getRiskLevel() {
        return null;
    }
    
    public final int getRiskScore() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getRiskFactorsJson() {
        return null;
    }
    
    public final long component1() {
        return 0L;
    }
    
    public final long component2() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.ankangban.health.core.storage.ChronicDiseaseType component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.ankangban.health.core.storage.RiskLevel component4() {
        return null;
    }
    
    public final int component5() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.ankangban.health.core.storage.ChronicRiskEntity copy(long id, long timestamp, @org.jetbrains.annotations.NotNull
    com.ankangban.health.core.storage.ChronicDiseaseType diseaseType, @org.jetbrains.annotations.NotNull
    com.ankangban.health.core.storage.RiskLevel riskLevel, int riskScore, @org.jetbrains.annotations.NotNull
    java.lang.String riskFactorsJson) {
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