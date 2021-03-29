package com.aequilibrium.transformers.service.implementation;

import com.aequilibrium.transformers.domain.BattleStatus;
import com.aequilibrium.transformers.domain.Transformer;
import com.aequilibrium.transformers.service.TransformsComparator;

public class TransformsComparatorFake implements TransformsComparator {
    @Override
    public BattleStatus compare(Transformer autobot, Transformer decepticon) {
        if (autobot.getId() == 1)
            return BattleStatus.AUTOBOT;
        else if (decepticon.getId() == 2)
            return BattleStatus.DECEPTICON;
        return BattleStatus.TIE;
    }
}
