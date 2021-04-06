package com.ha.transformers.service.implementation;

import com.ha.transformers.domain.BattleEvent;
import com.ha.transformers.service.EventPublisher;
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