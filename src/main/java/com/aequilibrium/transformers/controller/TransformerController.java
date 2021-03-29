package com.aequilibrium.transformers.controller;

import com.aequilibrium.transformers.domain.Transformer;
import com.aequilibrium.transformers.dto.TransformerRequest;
import com.aequilibrium.transformers.dto.TransformerResponse;
import com.aequilibrium.transformers.service.TransformerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TransformerController {

    private final TransformerService service;

    @Autowired
    public TransformerController(TransformerService service) {
        this.service = service;
    }

    @ResponseBody
    @PostMapping("/api/transformer")
    public TransformerResponse create(@Valid @RequestBody TransformerRequest request){
        Transformer transformer = mapFromRequest(request);
        return mapToResponse(service.create(transformer));
    }

    @ResponseBody
    @PutMapping("/api/transformer/{id}")
    public TransformerResponse update(@Valid @RequestBody TransformerRequest request, @PathVariable(name = "id") Long id){
        Transformer transformer = mapFromRequest(request, id);
        return mapToResponse(service.update(transformer));
    }

    @GetMapping("/api/transformer/{id}")
    public TransformerResponse get(@PathVariable(name = "id") Long id){
        return mapToResponse(service.get(id));
    }

    @DeleteMapping("/api/transformer/{id}")
    public void remove(@PathVariable(name = "id") Long id){
        service.remove(id);
    }

    @GetMapping("/api/transformer")
    public List<TransformerResponse> findAll(){
        return service.findAll()
                .stream().map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private Transformer mapFromRequest(TransformerRequest request, Long id) {
        Transformer transformer = mapFromRequest(request);
        transformer.setId(id);
        return transformer;
    }

    private Transformer mapFromRequest(TransformerRequest request) {
        Transformer transformer = new Transformer();
        transformer.setName(request.getName());
        transformer.setStrength(request.getStrength());
        transformer.setIntelligence(request.getIntelligence());
        transformer.setSpeed(request.getSpeed());
        transformer.setEndurance(request.getEndurance());
        transformer.setRank(request.getRank());
        transformer.setCourage(request.getCourage());
        transformer.setFirepower(request.getFirepower());
        transformer.setSkill(request.getSkill());
        return transformer;
    }

    private TransformerResponse mapToResponse(Transformer transformer) {
        TransformerResponse response = new TransformerResponse();
        response.setId(transformer.getId());
        response.setName(transformer.getName());
        response.setStrength(transformer.getStrength());
        response.setIntelligence(transformer.getIntelligence());
        response.setSpeed(transformer.getSpeed());
        response.setEndurance(transformer.getEndurance());
        response.setRank(transformer.getRank());
        response.setCourage(transformer.getCourage());
        response.setFirepower(transformer.getFirepower());
        response.setSkill(transformer.getSkill());
        response.setOverallRate(transformer.getOverallRate());
        return response;
    }
}