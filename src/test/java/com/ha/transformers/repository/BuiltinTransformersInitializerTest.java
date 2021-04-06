package com.ha.transformers.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BuiltinTransformersInitializerTest {

    private final BuiltinTransformersInitializer initializer;
    private final TransformerRepository repository;

    @Autowired
    BuiltinTransformersInitializerTest(BuiltinTransformersInitializer initializer, TransformerRepository repository) {
        this.initializer = initializer;
        this.repository = repository;
    }

    @Test
    public void initialize_createSomeTransformers_shouldBePassed(){
        assertTrue(repository.findAll().size() > 0);
    }
}