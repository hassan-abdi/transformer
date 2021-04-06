package com.ha.transformers.service.implementation;

import com.ha.transformers.domain.Score;
import com.ha.transformers.domain.Transformer;
import com.ha.transformers.service.TransformerService;
import com.ha.transformers.service.exception.InvalidTransformerException;

import java.util.Arrays;
import java.util.List;

public class TransformerServiceFake implements TransformerService {
    @Override
    public Transformer create(Transformer transformer) {
        return transformer;
    }

    @Override
    public Transformer update(Transformer transformer) {
        return transformer;
    }

    @Override
    public void remove(Long id) {
        if (id == 1230L)
            throw new InvalidTransformerException();
    }

    @Override
    public Transformer get(Long id) {
        if (id == 1230L)
            throw new InvalidTransformerException();
        Transformer autobot = new Transformer();
        autobot.setId(id);
        autobot.setName("Jackius");
        autobot.setStrength(new Score(10));
        autobot.setIntelligence(new Score(9));
        autobot.setSpeed(new Score(8));
        autobot.setEndurance(new Score(4));
        autobot.setFirepower(new Score(5));
        autobot.setSkill(new Score(5));
        autobot.setCourage(new Score(5));
        return autobot;
    }

    @Override
    public List<Transformer> findAll() {
        Transformer deception = new Transformer();
        deception.setId(2L);
        deception.setName("Jackius");
        deception.setStrength(new Score(10));
        deception.setIntelligence(new Score(9));
        deception.setSpeed(new Score(9));
        deception.setEndurance(new Score(6));
        deception.setFirepower(new Score(6));
        deception.setSkill(new Score(5));
        deception.setCourage(new Score(5));
        return Arrays.asList(get(1L), deception);
    }
}
