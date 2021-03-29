package com.aequilibrium.transformers.service;

import com.aequilibrium.transformers.domain.BattleEvent;

public interface EventPublisher {
    void publish(BattleEvent event);
}
