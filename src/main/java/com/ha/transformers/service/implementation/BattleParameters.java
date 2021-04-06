package com.ha.transformers.service.implementation;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties(prefix = "battle")
public class BattleParameters {
    private Integer courageSuperiority;
    private Integer strengthSuperiority;
    private Integer skillSuperiority;
    private List<String> superpowers;

    public Integer getCourageSuperiority() {
        return courageSuperiority;
    }

    public void setCourageSuperiority(Integer courageSuperiority) {
        this.courageSuperiority = courageSuperiority;
    }

    public Integer getStrengthSuperiority() {
        return strengthSuperiority;
    }

    public void setStrengthSuperiority(Integer strengthSuperiority) {
        this.strengthSuperiority = strengthSuperiority;
    }

    public Integer getSkillSuperiority() {
        return skillSuperiority;
    }

    public void setSkillSuperiority(Integer skillSuperiority) {
        this.skillSuperiority = skillSuperiority;
    }

    public List<String> getSuperpowers() {
        return superpowers;
    }

    public void setSuperpowers(List<String> superpowers) {
        this.superpowers = superpowers;
    }
}
