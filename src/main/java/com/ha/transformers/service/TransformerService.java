package com.ha.transformers.service;

import com.ha.transformers.domain.Transformer;

import java.util.List;

public interface TransformerService {
    Transformer create(Transformer transformer);
    Transformer update(Transformer transformer);
    void remove(Long id);
    Transformer get(Long id);
    List<Transformer> findAll();
}
