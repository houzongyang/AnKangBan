# OPPO Health SDK 集成与真机调试说明

## 1. SDK 集成步骤

本项目已完成 OPPO Health SDK 的代码层集成，为了使项目在真机上正常运行并获取数据，请执行以下步骤：

1.  **获取 SDK**: 请前往 OPPO 开发者平台下载最新的 Health SDK (aar/jar包)。
2.  **添加依赖**: 将下载的 `oppo_health_sdk.aar` (假设文件名) 放入 `app/libs` 目录下。
3.  **配置 Gradle**: `app/build.gradle` 中已配置 `implementation fileTree(dir: 'libs', include: ['*.jar','*.aar'])`，无需额外修改，只需确保文件在 libs 中。
4.  **替换 Stub**:
    *   目前项目中包含一个模拟类 `com.heytap.health.sdk.HealthAgent` (位于 `app/src/main/java/com/heytap/health/sdk/HealthAgent.kt`)，用于保证项目在未导入真实 SDK 时能编译通过。
    *   **导入真实 SDK 后，请删除该 Stub 文件**。
    *   如果真实 SDK 的 API 与 Stub 定义略有不同（例如包名或方法名），请修改 `com.ankangban.health.core.oppo.OppoHealthClientImpl.kt` 中的调用逻辑以适配真实 SDK。

## 2. 权限与鉴权

*   **AndroidManifest.xml**: 已添加必要的权限声明：
    *   `com.heytap.health.permission.READ_HEALTH_DATA`
    *   `com.heytap.health.permission.READ_SLEEP_DATA`
*   **AppID 配置**: 请在 `AndroidManifest.xml` 的 `<meta-data>` 标签中填入您在 OPPO 开发者平台申请的真实 `AppID`。
    ```xml
    <meta-data
        android:name="com.heytap.health.appid"
        android:value="替换为您的真实AppID" />
    ```
*   **初始化代码**: 在 `OppoHealthClientImpl.kt` 的 `initialize()` 方法中，请填入真实的 AppID 和 AppSecret。

## 3. 真机调试适配

*   **设备要求**: 建议使用 OPPO 手机 + OPPO Watch 4 Pro 进行联调。
*   **兜底逻辑**:
    *   如果 SDK 初始化失败（例如非 OPPO 手机或未安装健康 App），`OppoHealthClientImpl` 会自动降级使用 Android 原生传感器 (`Sensor.TYPE_STEP_COUNTER`) 获取步数数据。
    *   此时仅“今日步数”卡片会有数据更新，心率、血氧等卡片将显示 "--"。
*   **数据延迟**: 真实设备数据上报可能存在秒级延迟，属于正常现象。

## 4. 常见问题

*   **初始化失败 (Code 1001)**: 通常是 AppID/Secret 错误或包名与开发者平台注册不一致。
*   **无数据回调**: 请检查是否在手机“健康”App中授权了本应用读取数据。
