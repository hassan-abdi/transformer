package com.ha.transformers.controller;

import com.ha.transformers.domain.BattleResult;
import com.ha.transformers.dto.BattleRequest;
import com.ha.transformers.service.BattleService;
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
