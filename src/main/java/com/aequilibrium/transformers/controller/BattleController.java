package com.aequilibrium.transformers.controller;

import com.aequilibrium.transformers.domain.BattleResult;
import com.aequilibrium.transformers.dto.BattleRequest;
import com.aequilibrium.transformers.service.BattleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class BattleController {

    private final BattleService service;

    @Autowired
    public BattleController(BattleService service) {
        this.service = service;
    }

    @ResponseBody
    @PostMapping("/api/battle")
    public BattleResult start(@Valid @RequestBody BattleRequest request) {
        return service.fight(request);
    }
}
