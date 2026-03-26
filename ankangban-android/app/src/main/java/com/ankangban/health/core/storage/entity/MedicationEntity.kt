package com.ankangban.health.core.storage.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ColumnInfo

@Entity(tableName = "medications")
data class MedicationEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,

    @ColumnInfo(name = "name")
    val name: String, // 药品名称

    @ColumnInfo(name = "dosage")
    val dosage: String, // 服用剂量 (e.g., "1粒", "5ml")

    @ColumnInfo(name = "frequency")
    val frequency: String, // 服用频率描述 (e.g., "每日3次")

    @ColumnInfo(name = "total_stock")
    val totalStock: Int = 0, // 总库存/剩余量

    @ColumnInfo(name = "unit")
    val unit: String = "片", // 单位

    @ColumnInfo(name = "image_uri")
    val imageUri: String? = null, // 药盒正面图片URI

    @ColumnInfo(name = "side_image_uri")
    val sideImageUri: String? = null, // 药盒侧面/说明书图片URI

    @ColumnInfo(name = "create_time")
    val createTime: Long = System.currentTimeMillis(),

    @ColumnInfo(name = "ai_analysis_raw")
    val aiAnalysisRaw: String? = null // AI解析的原始结果JSON
)
