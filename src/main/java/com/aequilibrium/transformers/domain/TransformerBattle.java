package com.aequilibrium.transformers.domain;

import java.io.Serializable;

public class TransformerBattle implements Serializable {
    private final Transformer autobot;
    private final Transformer decepticon;
    private final BattleStatus status;

    public TransformerBattle(Transformer autobot, Transformer decepticon, BattleStatus status) {
        this.autobot = autobot;
        this.decepticon = decepticon;
        this.status = status;
    }

    public Transformer getAutobot() {
        return autobot;
    }

    public Transformer getDecepticon() {
        return decepticon;
    }

    public BattleStatus getStatus() {
        return status;
    }
}
