package com.aequilibrium.transformers.service.implementation;

import com.aequilibrium.transformers.domain.BattleResult;
import com.aequilibrium.transformers.dto.BattleRequest;
import com.aequilibrium.transformers.dto.TeamRequest;
import com.aequilibrium.transformers.service.BattleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootTest
public class BattleServiceImplTest {

    private final BattleService service;

    @Autowired
    public BattleServiceImplTest(BattleService service) {
        this.service = service;
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
        assertEquals(8, battleResult.getCount());
        assertTrue(battleResult.getWinner().isPresent());
        assertFalse(battleResult.getLoserSurvivors().isEmpty());
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