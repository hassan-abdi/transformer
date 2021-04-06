package com.ha.transformers.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScoreTest {

    @Test
    public void testCreate_validScore_shouldBePassed(){
        Score one = new Score(1);
        assertEquals(1, one.intValue());
        assertEquals(1, one.longValue());
        Score five = new Score(5);
        assertEquals(5, five.intValue());
        assertEquals(5, five.floatValue());
        Score ten = new Score(10);
        assertEquals(10, ten.intValue());
        assertEquals(10, ten.doubleValue());
    }

    @Test
    public void testCompare_equality_shouldBePassed(){
        Score one = new Score(1);
        assertEquals(0, one.compareTo(new Score(1)));
        Score five = new Score(5);
        assertEquals(-1, five.compareTo(new Score(6)));
        Score ten = new Score(10);
        assertEquals(1, ten.compareTo(new Score(3)));
    }

    @Test
    public void testEquals_equality_shouldBePassed(){
        Score one = new Score(1);
        assertEquals(new Score(1), one);
        Score five = new Score(5);
        assertNotEquals(new Score(6), five);
    }

    @Test
    public void testCreate_InvalidScore_ShouldThrewException(){
        assertThrows(IllegalArgumentException.class, () -> new Score(23));
    }

}