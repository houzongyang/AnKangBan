from __future__ import annotations

from dataclasses import dataclass

import torch
from transformers import AutoModelForCausalLM, AutoTokenizer


@dataclass
class MedGemmaConfig:
    model_name: str
    device: str = "cuda"


def load_medgemma(config: MedGemmaConfig):
    tokenizer = AutoTokenizer.from_pretrained(config.model_name)
    model = AutoModelForCausalLM.from_pretrained(config.model_name, torch_dtype=torch.float16)
    model.to(config.device)
    model.eval()
    return tokenizer, model


