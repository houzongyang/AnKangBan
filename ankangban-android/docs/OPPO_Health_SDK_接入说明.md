# OPPO Health SDK 接入说明

## 1. 准备
- 在 OPPO 开发者平台创建应用，开通健康数据能力，获取 App Key/Secret。
- 安装 OPPO Developer Studio，按照文档生成/下载 Android SDK AAR 包。

## 2. 工程配置
- 将官方提供的 `oppo-health-sdk.aar` 放入 `app/libs/` 目录。
- 在 `app/build.gradle` 已启用：
  ```groovy
  implementation fileTree(dir: 'libs', include: ['*.jar','*.aar'])
  ```
- 确保 Gradle JDK=17，Gradle=8.3（或官方建议组合），AGP=8.1.2。

## 3. 权限与清单
- `AndroidManifest.xml` 已包含常用权限：`INTERNET`, `ACCESS_NETWORK_STATE`, `BLUETOOTH*`, `ACTIVITY_RECOGNITION`, `BODY_SENSORS`, `RECORD_AUDIO`。
- 若官方 SDK 需要额外权限或 Provider/Service 声明，请按文档补充。

## 4. SDK 初始化
- 在 `OppoHealthClientImpl` 的 `initialize()` 中，调用官方初始化 API，完成鉴权与设备连接。
- 将官方监听器的各项体征数据，在回调中 `emit` 到对应 `MutableSharedFlow`。

## 5. 数据映射与回调
- 心率（实时/静息）→ `HeartRate`
- 血氧饱和度 → `SpO2`
- 腕温 → `WristTemp`
- 步数/卡路里 → `Steps`
- 呼吸率 → `RespRate`
- 心电 → `EcgSample`
- 睡眠（深睡/浅睡/效率/时长）→ `SleepSummary`

## 6. 动态权限与合规
- `HealthPermissions.ensure(Activity)` 在启动时统一申请。
- 首次授权弹窗需说明用途，符合 OPPO 隐私规范。

## 7. 真机调试
- 使用 OPPO 手机 + OPPO Watch 4 Pro，确保设备在 OHealth/HeyTap Health 中已配对且有数据。
- 运行 App，观察首页图表实时刷新。

