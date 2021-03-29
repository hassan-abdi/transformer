package com.aequilibrium.transformers.service;

import com.aequilibrium.transformers.domain.BattleStatus;
import com.aequilibrium.transformers.domain.Transformer;

public interface TransformsComparator {
    BattleStatus compare(Transformer autobot, Transformer decepticon);
}
