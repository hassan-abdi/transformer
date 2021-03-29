package com.aequilibrium.transformers.repository;

import com.aequilibrium.transformers.domain.Score;
import com.aequilibrium.transformers.domain.Transformer;
import com.aequilibrium.transformers.service.implementation.BattleParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Component
public class BuiltinTransformersInitializer implements ApplicationRunner {

    private final TransformerRepository repository;
    private final BattleParameters parameters;

    private static final List<String> names = Arrays.asList(
            "Autobot Cars",
            "Mini-Bots",
            "Others",
            "Dinobots",
            "Aerialbots",
            "Protectobots",
            "Female Autobots",
            "Technobots",
            "Throttlebots",
            "Targetmasters",
            "Headmasters",
            "Clonebots",
            "Junkions",
            "Insecticons",
            "Constructicons",
            "Coneheads",
            "Decepticon City",
            "Stunticons",
            "Combaticons",
            "Heralds of Unicron",
            "Multi Changers",
            "Predacons",
            "Battlechargers",
            "Terrorcons",
            "Targetmasters",
            "Headmasters",
            "Horrorcons",
            "Clonecons"
    );

    @Autowired
    public BuiltinTransformersInitializer(TransformerRepository repository, BattleParameters parameters) {
        this.repository = repository;
        this.parameters = parameters;
    }

    @Override
    public void run(ApplicationArguments args) {
        AtomicLong counter = new AtomicLong(0L);
        List<Transformer> list = shuffleCombine(parameters.getSuperpowers())
                .stream()
                .map(name -> {
                    Transformer transformer = new Transformer();
                    transformer.setId(counter.incrementAndGet());
                    transformer.setName(name);
                    transformer.setStrength(Score.random());
                    transformer.setIntelligence(Score.random());
                    transformer.setSpeed(Score.random());
                    transformer.setEndurance(Score.random());
                    transformer.setRank(Score.random());
                    transformer.setCourage(Score.random());
                    transformer.setFirepower(Score.random());
                    transformer.setSkill(Score.random());
                    return transformer;
                })
                .collect(Collectors.toList());
        repository.saveAll(list);
    }

    private List<String> shuffleCombine(List<String> b) {
        ArrayList<String> list = new ArrayList<>(BuiltinTransformersInitializer.names);
        list.addAll(b);
        Collections.shuffle(list);
        return list;
    }
}
