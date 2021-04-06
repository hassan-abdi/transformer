package com.ha.transformers.service.implementation;

import com.ha.transformers.domain.BattleStatus;
import com.ha.transformers.domain.Score;
import com.ha.transformers.domain.Transformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import static com.ha.transformers.domain.BattleStatus.*;

interface BattleRule {
    BattleStatus apply(Transformer autobot, Transformer decepticon);

    abstract class BaseRule implements BattleRule {
        private final BattleParameters parameters;

        protected BaseRule(BattleParameters parameters) {
            this.parameters = parameters;
        }

        protected BattleStatus compareByParam(Score autobotParam, Score decepticonParam, Integer max) {
            if (Math.abs(autobotParam.intValue() - decepticonParam.intValue()) >= max)
                return autobotParam.intValue() > decepticonParam.intValue() ? AUTOBOT : DECEPTICON;
            return CONTINUE;
        }
    }

    @Order(1)
    @Component
    class SuperPowerRule extends BaseRule {

        @Autowired
        public SuperPowerRule(BattleParameters parameters) {
            super(parameters);
        }

        @Override
        public BattleStatus apply(Transformer autobot, Transformer decepticon) {
            boolean autobotHasSuperPower = hasSuperPower(autobot);
            boolean decepticonHasSuperPower = hasSuperPower(decepticon);
            if (autobotHasSuperPower && decepticonHasSuperPower)
                return TIE;
            if (autobotHasSuperPower)
                return AUTOBOT;
            if (decepticonHasSuperPower)
                return DECEPTICON;
            return CONTINUE;
        }

        private boolean hasSuperPower(Transformer transformer){
            for(String name : super.parameters.getSuperpowers()){
                if (transformer.getName().equalsIgnoreCase(name))
                    return true;
            }
            return false;
        }
    }

    @Order(2)
    @Component
     class RunAwayRule extends BaseRule {

        @Autowired
        public RunAwayRule(BattleParameters parameters) {
            super(parameters);
        }

        @Override
        public BattleStatus apply(Transformer autobot, Transformer decepticon) {
            BattleStatus status = compareByParam(autobot.getCourage(), decepticon.getCourage(), super.parameters.getCourageSuperiority());
            if (status.isOver())
                return status;
            return compareByParam(autobot.getStrength(), decepticon.getStrength(), super.parameters.getStrengthSuperiority());
        }
    }

    @Order(3)
    @Component
    class SkillRule extends BaseRule {

        @Autowired
        protected SkillRule(BattleParameters parameters) {
            super(parameters);
        }

        @Override
        public BattleStatus apply(Transformer autobot, Transformer decepticon) {
            return compareByParam(autobot.getSkill(), decepticon.getSkill(), super.parameters.getSkillSuperiority());
        }
    }

    @Order(10)
    @Component
    class OverallRateRule extends BaseRule {

        @Autowired
        protected OverallRateRule(BattleParameters parameters) {
            super(parameters);
        }

        @Override
        public BattleStatus apply(Transformer autobot, Transformer decepticon) {
            int overallDiff = autobot.getOverallRate().compareTo(decepticon.getOverallRate());
            if (overallDiff > 0)
                return AUTOBOT;
            if (overallDiff < 0)
                return DECEPTICON;
            return TIE;
        }
    }
}