package com.ankangban.health.core.model

import java.time.Instant

// 健康指标类型（后续可扩展）
enum class MetricType {
    HEART_RATE,
    BLOOD_OXYGEN,
    STEPS
}

// 单条健康指标数据
data class HealthMetric(
    val type: MetricType,
    val timestamp: Long, // Unix 毫秒时间戳
    val value: Float,
    val sourceDevice: String = "mock"
)

