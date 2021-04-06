package com.ha.transformers.service.implementation;

import com.ha.transformers.domain.BattleEvent;
import com.ha.transformers.service.EventPublisher;
import org.springframework.stereotype.Component;

@Component
public class EventLogger implements EventPublisher {
    @Override
    public void publish(BattleEvent event) {
        System.out.println("event = " + event);
    }
}
