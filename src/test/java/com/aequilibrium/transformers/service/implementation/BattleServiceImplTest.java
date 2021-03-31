package com.aequilibrium.transformers.service.implementation;

import com.aequilibrium.transformers.domain.BattleEvent;
import com.aequilibrium.transformers.domain.BattleResult;
import com.aequilibrium.transformers.dto.BattleRequest;
import com.aequilibrium.transformers.dto.TeamRequest;
import com.aequilibrium.transformers.service.BattleService;
import com.aequilibrium.transformers.service.TransformerService;
import com.aequilibrium.transformers.service.TransformsComparator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BattleServiceImplTest {

    private final BattleService service;
    private final List<BattleEvent> events = new ArrayList<>();

    @Autowired
    public BattleServiceImplTest(TransformsComparator comparator, TransformerService service) {
        this.service = new BattleServiceImpl(comparator, service, events::add);
    }

    @BeforeEach
    public void restart(){
        events.clear();
    }

    @Test
    public void fight_autobotsIsHigher_shouldWin(){
        BattleRequest battleRequest = new BattleRequest();
        TeamRequest autobots = new TeamRequest();
        autobots.setName("Robo cup");
        autobots.setMembers(Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L, 8L, 9L));
        battleRequest.setAutobots(autobots);
        TeamRequest deceptions = new TeamRequest();
        deceptions.setName("Lipo cup");
        deceptions.setMembers(Arrays.asList(11L, 12L, 13L, 14L, 15L, 16L, 18L, 19L, 20L));
        battleRequest.setDecepticons(deceptions);
        BattleResult battleResult = service.fight(battleRequest);
        assertTrue(battleResult.getCount() > 0);
        assertTrue(events.size() >= 3);
    }

    @Test
    public void fight_empty_noWinner(){
        BattleRequest battleRequest = new BattleRequest();
        TeamRequest autobots = new TeamRequest();
        autobots.setName("Robo cup");
        autobots.setMembers(new ArrayList<>());
        battleRequest.setAutobots(autobots);
        TeamRequest deceptions = new TeamRequest();
        deceptions.setName("Lipo cup");
        deceptions.setMembers(new ArrayList<>());
        battleRequest.setDecepticons(deceptions);
        BattleResult battleResult = service.fight(battleRequest);
        assertEquals(0, battleResult.getCount());
        assertFalse(battleResult.getWinner().isPresent());
        assertTrue(battleResult.getLoserSurvivors().isEmpty());
    }
}