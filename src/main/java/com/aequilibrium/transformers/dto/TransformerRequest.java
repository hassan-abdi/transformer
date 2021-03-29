package com.aequilibrium.transformers.dto;

import com.aequilibrium.transformers.domain.Score;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class TransformerRequest {
    @NotBlank
    private String name;

    @NotNull
    private Score strength;

    @NotNull
    private Score intelligence;

    @NotNull
    private Score speed;

    @NotNull
    private Score endurance;

    @NotNull
    private Score rank;

    @NotNull
    private Score courage;

    @NotNull
    private Score firepower;

    @NotNull
    private Score skill;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Score getStrength() {
        return strength;
    }

    public void setStrength(Score strength) {
        this.strength = strength;
    }

    public Score getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(Score intelligence) {
        this.intelligence = intelligence;
    }

    public Score getSpeed() {
        return speed;
    }

    public void setSpeed(Score speed) {
        this.speed = speed;
    }

    public Score getEndurance() {
        return endurance;
    }

    public void setEndurance(Score endurance) {
        this.endurance = endurance;
    }

    public Score getRank() {
        return rank;
    }

    public void setRank(Score rank) {
        this.rank = rank;
    }

    public Score getCourage() {
        return courage;
    }

    public void setCourage(Score courage) {
        this.courage = courage;
    }

    public Score getFirepower() {
        return firepower;
    }

    public void setFirepower(Score firepower) {
        this.firepower = firepower;
    }

    public Score getSkill() {
        return skill;
    }

    public void setSkill(Score skill) {
        this.skill = skill;
    }
}
