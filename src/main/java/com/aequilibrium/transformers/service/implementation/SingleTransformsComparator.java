package com.aequilibrium.transformers.service.implementation;

import com.aequilibrium.transformers.domain.BattleStatus;
import com.aequilibrium.transformers.domain.Transformer;
import com.aequilibrium.transformers.service.TransformsComparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SingleTransformsComparator implements TransformsComparator {
    private final List<BattleRule> chainOfRules;

    @Autowired
    public SingleTransformsComparator(List<BattleRule> chainOfRules) {
        this.chainOfRules = chainOfRules;
    }

    public BattleStatus compare(Transformer autobot, Transformer decepticon){
        for (BattleRule rule : chainOfRules){
            BattleStatus status = rule.apply(autobot, decepticon);
            if (status.isOver())
                return status;
        }
        throw new RuntimeException("There should be a rule to break the chain!");
    }
}