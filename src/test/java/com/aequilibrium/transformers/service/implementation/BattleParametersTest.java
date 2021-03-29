package com.aequilibrium.transformers.service.implementation;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BattleParametersTest {

    private final BattleParameters parameters;

    @Autowired
    public BattleParametersTest(BattleParameters parameters) {
        this.parameters = parameters;
    }

    @Test
    public void checkConfigs_loadParams_shouldBePassed(){
        assertTrue(parameters.getSuperpowers().contains("Predaking"));
        assertNotNull(parameters.getCourageSuperiority());
        assertNotNull(parameters.getSkillSuperiority());
        assertNotNull(parameters.getStrengthSuperiority());
    }
}