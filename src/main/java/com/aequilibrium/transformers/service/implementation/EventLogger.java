package com.aequilibrium.transformers.service.implementation;

import com.aequilibrium.transformers.domain.BattleEvent;
import com.aequilibrium.transformers.service.EventPublisher;
import org.springframework.stereotype.Component;

@Component
public class EventLogger implements EventPublisher {
    @Override
    public void publish(BattleEvent event) {
        System.out.println("event = " + event);
    }
}
