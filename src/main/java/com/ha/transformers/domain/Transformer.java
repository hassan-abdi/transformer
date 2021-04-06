package com.ha.transformers.domain;


import javax.persistence.*;
import java.io.Serializable;

@Table(name = "transformer")
@Entity
public class Transformer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Score strength;
    private Score intelligence;
    private Score speed;
    private Score endurance;
    private Score rank;
    private Score courage;
    private Score firepower;
    private Score skill;

    public Integer getOverallRate(){
        return strength.intValue() + intelligence.intValue() + speed.intValue() + endurance.intValue()
                + firepower.intValue();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
