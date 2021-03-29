package com.aequilibrium.transformers.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TeamTest {

    @Test
    public void createAutobots(){
        Team team = Team.autobots("Hassan", Arrays.asList(new Transformer(), new Transformer(), new Transformer()));
        assertEquals(Group.AUTOBOTS, team.getGroup());
        assertEquals("Hassan", team.getName());
        assertEquals(3, team.getMembers().size());
    }

    @Test
    public void createDecepticons(){
        Team team = Team.decepticons("Abdi", Arrays.asList(new Transformer(), new Transformer(), new Transformer()));
        assertEquals(Group.DECEPTICONS, team.getGroup());
        assertEquals("Abdi", team.getName());
        assertEquals(3, team.getMembers().size());
    }

}