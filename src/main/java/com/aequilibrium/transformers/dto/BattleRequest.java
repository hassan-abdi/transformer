package com.aequilibrium.transformers.dto;

import java.io.Serializable;

public class BattleRequest implements Serializable {
    private TeamRequest autobots;
    private TeamRequest decepticons;

    public TeamRequest getAutobots() {
        return autobots;
    }

    public void setAutobots(TeamRequest autobots) {
        this.autobots = autobots;
    }

    public TeamRequest getDecepticons() {
        return decepticons;
    }

    public void setDecepticons(TeamRequest decepticons) {
        this.decepticons = decepticons;
    }
}
