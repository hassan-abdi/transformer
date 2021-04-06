package com.ha.transformers.service.implementation;

import com.ha.transformers.domain.BattleStatus;
import com.ha.transformers.domain.Score;
import com.ha.transformers.domain.Transformer;
import com.ha.transformers.service.TransformsComparator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class SingleTransformsComparatorTest {
    private final TransformsComparator comparator;

    @Autowired
    public SingleTransformsComparatorTest(TransformsComparator comparator) {
        this.comparator = comparator;
    }

    @Test
    public void compare_withoutBreakChain_shouldThrowException(){
        assertThrows(RuntimeException.class, () -> new SingleTransformsComparator(Collections.emptyList())
                .compare(new Transformer(), new Transformer()));
    }

    @Test
    public void compare_superPower_shouldBePassed() {
        Transformer autobotS = new Transformer();
        autobotS.setName("Optimus Prime");
        Transformer deceptionS = new Transformer();
        deceptionS.setName("Predaking");
        BattleStatus status = comparator.compare(autobotS, deceptionS);
        assertEquals(BattleStatus.TIE, status);

        Transformer autobot = new Transformer();
        autobot.setName("shaghool");
        status = comparator.compare(autobot, deceptionS);
        assertEquals(BattleStatus.DECEPTICON, status);

        Transformer deception = new Transformer();
        deception.setName("baghool");
        status = comparator.compare(autobotS, deception);
        assertEquals(BattleStatus.AUTOBOT, status);
    }

    @Test
    public void compare_runAway_shouldBePassed(){
        Transformer autobotS = new Transformer();
        autobotS.setCourage(new Score(10));
        autobotS.setStrength(new Score(10));
        autobotS.setName("Comonus");
        Transformer deceptionS = new Transformer();
        deceptionS.setCourage(new Score(10));
        deceptionS.setStrength(new Score(10));
        deceptionS.setName("Timonus");

        Transformer autobot = new Transformer();
        autobot.setCourage(new Score(5));
        autobot.setStrength(new Score(5));
        autobot.setName("Tili");
        BattleStatus status = comparator.compare(autobot, deceptionS);
        assertEquals(BattleStatus.DECEPTICON, status);

        Transformer deception = new Transformer();
        deception.setCourage(new Score(5));
        deception.setStrength(new Score(5));
        deception.setName("Jackius");
        status = comparator.compare(autobotS, deception);
        assertEquals(BattleStatus.AUTOBOT, status);
    }

    @Test
    public void apply_skill_shouldBePassed(){
        Transformer autobotS = new Transformer();
        autobotS.setSkill(new Score(10));
        autobotS.setCourage(new Score(5));
        autobotS.setStrength(new Score(6));
        autobotS.setName("Skillfull");
        Transformer deceptionS = new Transformer();
        deceptionS.setSkill(new Score(10));
        deceptionS.setCourage(new Score(6));
        deceptionS.setStrength(new Score(5));
        deceptionS.setName("expert");

        Transformer autobot = new Transformer();
        autobot.setSkill(new Score(5));
        autobot.setCourage(new Score(5));
        autobot.setStrength(new Score(5));
        autobot.setName("Tili");
        BattleStatus status = comparator.compare(autobot, deceptionS);
        assertEquals(BattleStatus.DECEPTICON, status);

        Transformer deception = new Transformer();
        deception.setSkill(new Score(5));
        deception.setCourage(new Score(5));
        deception.setStrength(new Score(5));
        deception.setName("Jackius");
        status = comparator.compare(autobotS, deception);
        assertEquals(BattleStatus.AUTOBOT, status);
    }

    @Test
    public void compare_allFlow_shouldBeDeception(){
        Transformer autobot = new Transformer();
        autobot.setStrength(new Score(10));
        autobot.setIntelligence(new Score(9));
        autobot.setSpeed(new Score(8));
        autobot.setEndurance(new Score(4));
        autobot.setFirepower(new Score(5));
        autobot.setSkill(new Score(5));
        autobot.setCourage(new Score(5));
        autobot.setName("Jackius");
        Transformer deception = new Transformer();
        deception.setStrength(new Score(10));
        deception.setIntelligence(new Score(9));
        deception.setSpeed(new Score(9));
        deception.setEndurance(new Score(6));
        deception.setFirepower(new Score(6));
        deception.setSkill(new Score(5));
        deception.setCourage(new Score(5));
        deception.setName("Jackius");
        BattleStatus status = comparator.compare(autobot, deception);
        assertEquals(BattleStatus.DECEPTICON, status);
        System.out.println("autobot.getOverallRate = " + autobot.getOverallRate());
        System.out.println("deception.getOverallRate = " + deception.getOverallRate());
    }
}