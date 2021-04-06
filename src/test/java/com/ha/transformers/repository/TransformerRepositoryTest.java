package com.ha.transformers.repository;

import com.ha.transformers.domain.Score;
import com.ha.transformers.domain.Transformer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TransformerRepositoryTest {

    private final TransformerRepository repository;
    private Transformer transformer1;

    @Autowired
    TransformerRepositoryTest(TransformerRepository repository) {
        this.repository = repository;
    }

    @BeforeEach
    public void saveSomeTransformers(){
        transformer1 = new Transformer();
        transformer1.setName("Hansool");
        transformer1.setStrength(new Score(8));
        transformer1.setIntelligence(new Score(10));
        transformer1.setSpeed(new Score(6));
        transformer1.setEndurance(new Score(7));
        transformer1.setRank(new Score(10));
        transformer1.setCourage(new Score(8));
        transformer1.setFirepower(new Score(4));
        transformer1.setSkill(new Score(8));
        repository.save(transformer1);
    }

    @Test
    public void save_shouldReturnId_shouldBePassed(){
        Transformer transformer = new Transformer();
        transformer.setName("Hansool");
        transformer.setStrength(new Score(8));
        transformer.setIntelligence(new Score(10));
        transformer.setSpeed(new Score(6));
        transformer.setEndurance(new Score(7));
        transformer.setRank(new Score(10));
        transformer.setCourage(new Score(8));
        transformer.setFirepower(new Score(4));
        transformer.setSkill(new Score(8));
        repository.save(transformer);
        assertNotNull(transformer.getId());
    }

    @Test
    public void get_findOneExists_shouldBePassed(){
        Optional<Transformer> byId = repository.findById(transformer1.getId());
        assertTrue(byId.isPresent());
        assertEquals("Hansool", byId.get().getName());
        assertEquals(new Score(8), byId.get().getStrength());
        assertEquals(new Score(10), byId.get().getIntelligence());
        assertEquals(new Score(6), byId.get().getSpeed());
        assertEquals(new Score(7), byId.get().getEndurance());
        assertEquals(new Score(10), byId.get().getRank());
        assertEquals(new Score(8), byId.get().getCourage());
        assertEquals(new Score(4), byId.get().getFirepower());
        assertEquals(new Score(8), byId.get().getSkill());
    }

    @Test
    public void remove_deleteOneExists_shouldBePassed(){
        repository.deleteById(transformer1.getId());
        assertFalse(repository.findById(transformer1.getId()).isPresent());
    }
}