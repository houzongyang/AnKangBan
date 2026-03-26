package com.ankangban.health.core.storage.entity;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001Bi\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u000fJ\t\u0010\u001d\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0005H\u00c6\u0003J\t\u0010 \u001a\u00020\u0005H\u00c6\u0003J\t\u0010!\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\"\u001a\u00020\tH\u00c6\u0003J\t\u0010#\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010&\u001a\u00020\u0003H\u00c6\u0003Js\u0010\'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\r\u001a\u00020\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010+\u001a\u00020\tH\u00d6\u0001J\t\u0010,\u001a\u00020\u0005H\u00d6\u0001R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0011\u00a8\u0006-"}, d2 = {"Lcom/ankangban/health/core/storage/entity/MedicationEntity;", "", "id", "", "name", "", "dosage", "frequency", "totalStock", "", "unit", "imageUri", "sideImageUri", "createTime", "aiAnalysisRaw", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "getAiAnalysisRaw", "()Ljava/lang/String;", "getCreateTime", "()J", "getDosage", "getFrequency", "getId", "getImageUri", "getName", "getSideImageUri", "getTotalStock", "()I", "getUnit", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"})
@androidx.room.Entity(tableName = "medications")
public final class MedicationEntity {
    @androidx.room.PrimaryKey(autoGenerate = true)
    private final long id = 0L;
    @androidx.room.ColumnInfo(name = "name")
    @org.jetbrains.annotations.NotNull
    private final java.lang.String name = null;
    @androidx.room.ColumnInfo(name = "dosage")
    @org.jetbrains.annotations.NotNull
    private final java.lang.String dosage = null;
    @androidx.room.ColumnInfo(name = "frequency")
    @org.jetbrains.annotations.NotNull
    private final java.lang.String frequency = null;
    @androidx.room.ColumnInfo(name = "total_stock")
    private final int totalStock = 0;
    @androidx.room.ColumnInfo(name = "unit")
    @org.jetbrains.annotations.NotNull
    private final java.lang.String unit = null;
    @androidx.room.ColumnInfo(name = "image_uri")
    @org.jetbrains.annotations.Nullable
    private final java.lang.String imageUri = null;
    @androidx.room.ColumnInfo(name = "side_image_uri")
    @org.jetbrains.annotations.Nullable
    private final java.lang.String sideImageUri = null;
    @androidx.room.ColumnInfo(name = "create_time")
    private final long createTime = 0L;
    @androidx.room.ColumnInfo(name = "ai_analysis_raw")
    @org.jetbrains.annotations.Nullable
    private final java.lang.String aiAnalysisRaw = null;
    
    public MedicationEntity(long id, @org.jetbrains.annotations.NotNull
    java.lang.String name, @org.jetbrains.annotations.NotNull
    java.lang.String dosage, @org.jetbrains.annotations.NotNull
    java.lang.String frequency, int totalStock, @org.jetbrains.annotations.NotNull
    java.lang.String unit, @org.jetbrains.annotations.Nullable
    java.lang.String imageUri, @org.jetbrains.annotations.Nullable
    java.lang.String sideImageUri, long createTime, @org.jetbrains.annotations.Nullable
    java.lang.String aiAnalysisRaw) {
        super();
    }
    
    public final long getId() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getDosage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getFrequency() {
        return null;
    }
    
    public final int getTotalStock() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getUnit() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getImageUri() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getSideImageUri() {
        return null;
    }
    
    public final long getCreateTime() {
        return 0L;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getAiAnalysisRaw() {
        return null;
    }
    
    public final long component1() {
        return 0L;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component4() {
        return null;
    }
    
    public final int component5() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component8() {
        return null;
    }
    
    public final long component9() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.ankangban.health.core.storage.entity.MedicationEntity copy(long id, @org.jetbrains.annotations.NotNull
    java.lang.String name, @org.jetbrains.annotations.NotNull
    java.lang.String dosage, @org.jetbrains.annotations.NotNull
    java.lang.String frequency, int totalStock, @org.jetbrains.annotations.NotNull
    java.lang.String unit, @org.jetbrains.annotations.Nullable
    java.lang.String imageUri, @org.jetbrains.annotations.Nullable
    java.lang.String sideImageUri, long createTime, @org.jetbrains.annotations.Nullable
    java.lang.String aiAnalysisRaw) {
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