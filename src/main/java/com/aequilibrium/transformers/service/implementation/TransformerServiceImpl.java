package com.aequilibrium.transformers.service.implementation;

import com.aequilibrium.transformers.domain.Transformer;
import com.aequilibrium.transformers.repository.TransformerRepository;
import com.aequilibrium.transformers.service.TransformerService;
import com.aequilibrium.transformers.service.exception.InvalidTransformerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransformerServiceImpl implements TransformerService {

    private final TransformerRepository repository;

    @Autowired
    public TransformerServiceImpl(TransformerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Transformer create(Transformer transformer) {
        return repository.save(transformer);
    }

    @Override
    public Transformer update(Transformer transformer) {
        checkExists(transformer.getId());
        return repository.save(transformer);
    }

    @Override
    public void remove(Long id) {
        checkExists(id);
        repository.deleteById(id);
    }

    @Override
    public Transformer get(Long id) {
        return repository.findById(id).orElseThrow(InvalidTransformerException::new);
    }

    @Override
    public List<Transformer> findAll() {
        return repository.findAll();
    }

    private void checkExists(Long id) {
        if (!repository.findById(id).isPresent())
            throw new InvalidTransformerException();
    }
}