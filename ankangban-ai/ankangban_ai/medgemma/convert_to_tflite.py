from __future__ import annotations

from pathlib import Path

import tensorflow as tf


def convert_saved_model_to_tflite(saved_model_dir: Path, output_path: Path) -> None:
    converter = tf.lite.TFLiteConverter.from_saved_model(str(saved_model_dir))
    tflite_model = converter.convert()
    output_path.write_bytes(tflite_model)


