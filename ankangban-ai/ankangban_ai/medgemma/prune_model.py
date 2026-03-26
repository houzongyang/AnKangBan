from __future__ import annotations

import torch


def structured_prune(model: torch.nn.Module, keep_ratio: float = 0.2) -> torch.nn.Module:
    _ = keep_ratio
    return model


