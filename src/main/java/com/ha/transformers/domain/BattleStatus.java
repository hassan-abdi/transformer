package com.ha.transformers.domain;

public enum BattleStatus {
    CONTINUE, AUTOBOT, DECEPTICON, TIE;

    public boolean isOver(){
        return !this.equals(CONTINUE);
    }
}
