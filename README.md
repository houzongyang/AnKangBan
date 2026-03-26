# 安康伴 (AnKangBan) - 智慧健康伴侣

安康伴是一款全方位的智慧健康管理系统，旨在通过人工智能技术和移动互联网手段，为用户提供便捷、专业的健康监测、风险预警及医疗咨询服务。

## 🚀 项目组成

本项目由以下三个核心组件构成：

1.  **[ankangban-backend](./ankangban-backend)**: 基于 Flask 的后端 API 服务。
    *   负责用户认证（JWT）、家庭成员管理、健康数据同步与备份。
    *   技术栈：Flask, SQLAlchemy, Flask-Migrate, PyMySQL, SQLite。
2.  **[ankangban-ai](./ankangban-ai)**: 人工智能核心组件。
    *   包含基于 MedGemma 的医疗咨询模型和针对慢性病的风险预测模型。
    *   技术栈：TensorFlow, PyTorch, Transformers, Scikit-learn, ONNX。
3.  **[ankangban-android](./ankangban-android)**: 原生 Android 移动客户端。
    *   提供直观的健康看板、慢性病管理界面、AI 咨询对话框及家庭健康监测功能。
    *   技术栈：Android SDK, Kotlin/Java, Gradle, ECharts (用于数据可视化)。

## ✨ 核心功能

*   **AI 医疗咨询**：集成 MedGemma 大模型，提供 7x24 小时的专业医疗建议与健康问答。
*   **健康风险预警**：利用机器学习算法，根据用户的健康指标（如心率、血压、睡眠等）预测慢性病风险。
*   **家庭健康共享**：支持添加家庭成员，实时查看亲友的健康状态，实现家庭健康互助。
*   **健康看板与趋势**：通过直观的图表展示各项健康数据的历史趋势，帮助用户掌握健康变化。
*   **数据管理与备份**：支持通过蓝牙设备采集数据，并提供云端备份功能，确保健康数据永不丢失。

## 🛠️ 快速开始

### 后端服务 (ankangban-backend)
1. 进入目录：`cd ankangban-backend`
2. 安装依赖：`pip install -r requirements.txt`
3. 启动应用：`python app.py`
   * 默认运行在 `http://127.0.0.1:5000`

### AI 组件 (ankangban-ai)
1. 进入目录：`cd ankangban-ai`
2. 安装依赖：`pip install -r requirements.txt`
3. 详细模型训练与转换说明请参考 `ankangban_ai/risk_model` 和 `ankangban_ai/medgemma` 目录下的文档。

### Android 客户端 (ankangban-android)
1. 使用 Android Studio 打开 `ankangban-android` 目录。
2. 等待 Gradle 同步完成。
3. 连接 Android 设备或模拟器，点击 "Run" 即可安装运行。

## 📂 项目结构

```text
软件大赛/
├── ankangban-ai/            # AI 模型训练与推理
│   ├── ankangban_ai/
│   │   ├── medgemma/        # 医疗大模型相关
│   │   └── risk_model/      # 风险预测模型相关
│   └── requirements.txt
├── ankangban-android/       # Android 移动端源码
│   ├── app/                 # 应用核心模块
│   └── build.gradle
└── ankangban-backend/       # 后端服务源码
    ├── ankangban_backend/   # 业务逻辑与路由
    ├── app.py               # 入口文件
    └── requirements.txt
```

---
*本项作为软件大赛参赛作品开发。*
