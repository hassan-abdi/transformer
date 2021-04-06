package com.ha.transformers.service.implementation;

import com.ha.transformers.domain.Score;
import com.ha.transformers.domain.Transformer;
import com.ha.transformers.repository.TransformerRepository;
import com.ha.transformers.service.TransformerService;
import com.ha.transformers.service.exception.InvalidTransformerException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class TransformerServiceImplTest {

    private TransformerService service;
    @MockBean
    private TransformerRepository repository;

    @BeforeEach
    public void init(){
        service = new TransformerServiceImpl(repository);
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
        service.create(transformer);
    }

    @Test
    public void get_findOneNotExists_shouldThrowException(){
        assertThrows(InvalidTransformerException.class, () -> service.get(1230L));
      }

    @Test
    public void findAll_findAll_shouldReturnAll(){
        service.findAll();
    }

    @Test
    public void remove_findOneNotExists_shouldThrowException(){
        assertThrows(InvalidTransformerException.class, () -> service.remove(1230L));
    }
}