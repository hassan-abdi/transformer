package com.aequilibrium.transformers.service.implementation;

import com.aequilibrium.transformers.domain.BattleEvent;
import com.aequilibrium.transformers.service.EventPublisher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EventLoggerTest {

    private final EventPublisher publisher;

    @Autowired
    public EventLoggerTest(EventPublisher publisher) {
        this.publisher = publisher;
    }

    @Test
    public void testPublisher(){
        publisher.publish(new BattleEvent(BattleEvent.Type.WINNER));
    }
}