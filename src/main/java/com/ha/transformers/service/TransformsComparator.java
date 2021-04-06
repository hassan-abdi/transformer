package com.ha.transformers.service;

import com.ha.transformers.domain.BattleStatus;
import com.ha.transformers.domain.Transformer;

public interface TransformsComparator {
    BattleStatus compare(Transformer autobot, Transformer decepticon);
}
