package com.ankangban.health.core.storage

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ai_content")
data class AiContentEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val title: String,
    val content: String,
    val type: String, // "助眠故事" or "冥想引导"
    val tags: String, // Comma separated tags
    val durationMinutes: Int,
    val suggestedBgMusic: String,
    val createdAt: Long = System.currentTimeMillis()
)