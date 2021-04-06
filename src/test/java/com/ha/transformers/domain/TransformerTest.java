package com.ha.transformers.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransformerTest {

    @Test
    public void overallRate_valid_shouldBePassed(){
        Transformer transformer = new Transformer();
        transformer.setName("Josh");
        transformer.setStrength(new Score(8));
        transformer.setIntelligence(new Score(10));
        transformer.setSpeed(new Score(6));
        transformer.setEndurance(new Score(7));
        transformer.setRank(new Score(10));
        transformer.setCourage(new Score(8));
        transformer.setFirepower(new Score(4));
        transformer.setSkill(new Score(8));
        assertEquals(8 + 10 + 6 + 7 + 4, transformer.getOverallRate());
    }
}