package com.ha.transformers.service.implementation;

import com.ha.transformers.domain.BattleStatus;
import com.ha.transformers.domain.Score;
import com.ha.transformers.domain.Transformer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class BattleRuleTest {

    private final List<BattleRule> rules;

    @Autowired
    BattleRuleTest(List<BattleRule> rules) {
        this.rules = rules;
    }

    @Test
    public void numberOfRules_shouldBePassed() {
        assertEquals(4, rules.size());
        assertTrue(rules.get(0).getClass().isAssignableFrom(BattleRule.SuperPowerRule.class));
        assertTrue(rules.get(1).getClass().isAssignableFrom(BattleRule.RunAwayRule.class));
        assertTrue(rules.get(2).getClass().isAssignableFrom(BattleRule.SkillRule.class));
        assertTrue(rules.get(3).getClass().isAssignableFrom(BattleRule.OverallRateRule.class));
    }

    @SpringBootTest
    public static class SuperPowerRuleTest {
        private final BattleRule.SuperPowerRule battleRule;

        @Autowired
        public SuperPowerRuleTest(BattleRule.SuperPowerRule battleRule) {
            this.battleRule = battleRule;
        }

        @Test
        public void apply_superPower_shouldBePassed() {
            Transformer autobotS = new Transformer();
            autobotS.setName("Optimus Prime");
            Transformer deceptionS = new Transformer();
            deceptionS.setName("Predaking");
            BattleStatus status = battleRule.apply(autobotS, deceptionS);
            assertEquals(BattleStatus.TIE, status);

            Transformer autobot = new Transformer();
            autobot.setName("shaghool");
            status = battleRule.apply(autobot, deceptionS);
            assertEquals(BattleStatus.DECEPTICON, status);

            Transformer deception = new Transformer();
            deception.setName("baghool");
            status = battleRule.apply(autobotS, deception);
            assertEquals(BattleStatus.AUTOBOT, status);

            status = battleRule.apply(autobot, deception);
            assertEquals(BattleStatus.CONTINUE, status);
        }
    }

    @SpringBootTest
    public static class RunAwayRuleTest {
        private final BattleRule.RunAwayRule battleRule;

        @Autowired
        public RunAwayRuleTest(BattleRule.RunAwayRule battleRule) {
            this.battleRule = battleRule;
        }

        @Test
        public void apply_runAway_shouldBePassed(){
            Transformer autobotS = new Transformer();
            autobotS.setCourage(new Score(10));
            autobotS.setStrength(new Score(10));
            Transformer deceptionS = new Transformer();
            deceptionS.setCourage(new Score(10));
            deceptionS.setStrength(new Score(10));
            BattleStatus status = battleRule.apply(autobotS, deceptionS);
            assertEquals(BattleStatus.CONTINUE, status);

            Transformer autobot = new Transformer();
            autobot.setCourage(new Score(5));
            autobot.setStrength(new Score(5));
            status = battleRule.apply(autobot, deceptionS);
            assertEquals(BattleStatus.DECEPTICON, status);

            Transformer deception = new Transformer();
            deception.setCourage(new Score(5));
            deception.setStrength(new Score(5));
            status = battleRule.apply(autobotS, deception);
            assertEquals(BattleStatus.AUTOBOT, status);

            status = battleRule.apply(autobot, deception);
            assertEquals(BattleStatus.CONTINUE, status);
        }
    }

    @SpringBootTest
    public static class SkillRuleTest {
        private final BattleRule.SkillRule battleRule;

        @Autowired
        public SkillRuleTest(BattleRule.SkillRule battleRule) {
            this.battleRule = battleRule;
        }

        @Test
        public void apply_skill_shouldBePassed(){
            Transformer autobotS = new Transformer();
            autobotS.setSkill(new Score(10));
            Transformer deceptionS = new Transformer();
            deceptionS.setSkill(new Score(10));
            BattleStatus status = battleRule.apply(autobotS, deceptionS);
            assertEquals(BattleStatus.CONTINUE, status);

            Transformer autobot = new Transformer();
            autobot.setSkill(new Score(5));
            status = battleRule.apply(autobot, deceptionS);
            assertEquals(BattleStatus.DECEPTICON, status);

            Transformer deception = new Transformer();
            deception.setSkill(new Score(5));
            status = battleRule.apply(autobotS, deception);
            assertEquals(BattleStatus.AUTOBOT, status);

            status = battleRule.apply(autobot, deception);
            assertEquals(BattleStatus.CONTINUE, status);
        }
    }


    @SpringBootTest
    public static class OverallRateRuleTest {
        private final BattleRule.OverallRateRule battleRule;

        @Autowired
        public OverallRateRuleTest(BattleRule.OverallRateRule battleRule) {
            this.battleRule = battleRule;
        }

        @Test
        public void apply_overallRate_shouldBeTie(){
            Transformer autobot = new Transformer();
            autobot.setStrength(new Score(10));
            autobot.setIntelligence(new Score(9));
            autobot.setSpeed(new Score(8));
            autobot.setEndurance(new Score(6));
            autobot.setFirepower(new Score(7));
            Transformer deception = new Transformer();
            deception.setStrength(new Score(10));
            deception.setIntelligence(new Score(9));
            deception.setSpeed(new Score(9));
            deception.setEndurance(new Score(6));
            deception.setFirepower(new Score(6));
            BattleStatus status = battleRule.apply(autobot, deception);
            assertEquals(BattleStatus.TIE, status);
            System.out.println("autobot.getOverallRate = " + autobot.getOverallRate());
            System.out.println("deception.getOverallRate = " + deception.getOverallRate());
        }

        @Test
        public void apply_overallRate_shouldBeDeception(){
            Transformer autobot = new Transformer();
            autobot.setStrength(new Score(10));
            autobot.setIntelligence(new Score(9));
            autobot.setSpeed(new Score(8));
            autobot.setEndurance(new Score(4));
            autobot.setFirepower(new Score(5));
            Transformer deception = new Transformer();
            deception.setStrength(new Score(10));
            deception.setIntelligence(new Score(9));
            deception.setSpeed(new Score(9));
            deception.setEndurance(new Score(6));
            deception.setFirepower(new Score(6));
            BattleStatus status = battleRule.apply(autobot, deception);
            assertEquals(BattleStatus.DECEPTICON, status);
            System.out.println("autobot.getOverallRate = " + autobot.getOverallRate());
            System.out.println("deception.getOverallRate = " + deception.getOverallRate());
        }

        @Test
        public void apply_overallRate_shouldBeAutobot(){
            Transformer autobot = new Transformer();
            autobot.setStrength(new Score(10));
            autobot.setIntelligence(new Score(9));
            autobot.setSpeed(new Score(8));
            autobot.setEndurance(new Score(8));
            autobot.setFirepower(new Score(7));
            Transformer deception = new Transformer();
            deception.setStrength(new Score(10));
            deception.setIntelligence(new Score(9));
            deception.setSpeed(new Score(9));
            deception.setEndurance(new Score(6));
            deception.setFirepower(new Score(6));
            BattleStatus status = battleRule.apply(autobot, deception);
            assertEquals(BattleStatus.AUTOBOT, status);
            System.out.println("autobot.getOverallRate = " + autobot.getOverallRate());
            System.out.println("deception.getOverallRate = " + deception.getOverallRate());
        }

    }

}