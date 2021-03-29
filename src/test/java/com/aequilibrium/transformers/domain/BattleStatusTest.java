package com.aequilibrium.transformers.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BattleStatusTest {

    @Test
    public void testIsOverShouldReturnTrue(){
        BattleStatus status = BattleStatus.TIE;
        assertTrue(status.isOver());
        status = BattleStatus.AUTOBOT;
        assertTrue(status.isOver());
        status = BattleStatus.DECEPTICON;
        assertTrue(status.isOver());
    }

    @Test
    public void testIsOverShouldReturnFalse(){
        BattleStatus status = BattleStatus.CONTINUE;
        assertFalse(status.isOver());
    }

}