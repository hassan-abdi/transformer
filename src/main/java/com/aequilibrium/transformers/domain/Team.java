package com.aequilibrium.transformers.domain;

import java.util.List;

public class Team {
    private String name;
    private Group group;
    private List<Transformer> members;

    public Team(Group group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public List<Transformer> getMembers() {
        return members;
    }

    public void setMembers(List<Transformer> members) {
        this.members = members;
    }

    public static Team autobots(String name, List<Transformer> members){
        Team team = new Team(Group.AUTOBOTS);
        team.setName(name);
        team.setMembers(members);
        return team;
    }

    public static Team decepticons(String name, List<Transformer> members){
        Team team = new Team(Group.DECEPTICONS);
        team.setName(name);
        team.setMembers(members);
        return team;
    }
}
