package com.ha.transformers.service;

import com.ha.transformers.domain.BattleEvent;

public interface EventPublisher {
    void publish(BattleEvent event);
}
