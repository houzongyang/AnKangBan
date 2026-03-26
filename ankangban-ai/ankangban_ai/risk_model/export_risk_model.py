from __future__ import annotations

import json
from pathlib import Path

import joblib
import numpy as np


def export_to_json(joblib_path: Path, json_path: Path) -> None:
    model = joblib.load(joblib_path)

    if not hasattr(model, "coef_") or not hasattr(model, "intercept_"):
        raise ValueError("仅示例：当前导出逻辑假设为 LogisticRegression 模型")

    data = {
        "type": "logistic_regression",
        "coef": model.coef_.tolist(),
        "intercept": model.intercept_.tolist(),
    }

    json_path.write_text(json.dumps(data, ensure_ascii=False, indent=2), encoding="utf-8")


def main() -> None:
    root = Path(__file__).parent
    joblib_path = root / "risk_model.joblib"
    json_path = root / "risk_model_export.json"
    export_to_json(joblib_path, json_path)


if __name__ == "__main__":
    main()

