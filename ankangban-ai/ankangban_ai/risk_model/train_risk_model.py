from __future__ import annotations

from pathlib import Path

import joblib
import numpy as np
from sklearn.linear_model import LogisticRegression


def train_dummy_risk_model() -> LogisticRegression:
    x = np.random.rand(100, 7)
    y = np.random.randint(0, 2, size=(100,))

    model = LogisticRegression()
    model.fit(x, y)
    return model


def main() -> None:
    model = train_dummy_risk_model()
    output_path = Path(__file__).parent / "risk_model.joblib"
    joblib.dump(model, output_path)


if __name__ == "__main__":
    main()

