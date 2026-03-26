package com.ankangban.health.core.source

enum class DataSourceType {
    DEVICE_SENSOR,
    LOCAL_FILE,
    THIRD_PARTY_SDK
}

enum class SourceStatus {
    CONNECTED,
    NOT_CONNECTED,
    NO_PERMISSION
}

data class DataSourceState(
    val type: DataSourceType,
    val status: SourceStatus,
    val message: String
)
