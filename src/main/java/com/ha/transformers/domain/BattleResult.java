package com.ha.transformers.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BattleResult implements Serializable {
    private final Integer count;
    private Team winner;
    private final List<Transformer> loserSurvivors;

    public BattleResult(Integer count, Team winner, List<Transformer> loserSurvivors) {
        this.count = count;
        this.winner = winner;
        this.loserSurvivors = loserSurvivors;
    }

    public BattleResult(Integer count) {
        this.count = count;
        this.loserSurvivors = new ArrayList<>();
    }

    public static BattleResult tie(int count) {
        return new BattleResult(count);
    }

    public Integer getCount() {
        return count;
    }

    public Optional<Team> getWinner() {
        return Optional.ofNullable(winner);
    }

    public List<Transformer> getLoserSurvivors() {
        return loserSurvivors;
    }
}
