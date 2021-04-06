package com.ha.transformers.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BattleResultTest {

    @Test
    public void testWinnerAutobots(){
        BattleResult battleResult = new BattleResult(5, new Team(Group.AUTOBOTS),
                Arrays.asList(new Transformer(), new Transformer()));
        assertEquals(5, battleResult.getCount());
        assertTrue(battleResult.getWinner().isPresent());
        assertEquals(Group.AUTOBOTS, battleResult.getWinner().get().getGroup());
        assertEquals(2, battleResult.getLoserSurvivors().size());
    }

    @Test
    public void testTie(){
        BattleResult battleResult = BattleResult.tie(2);
        assertEquals(2, battleResult.getCount());
        assertFalse(battleResult.getWinner().isPresent());
    }
}