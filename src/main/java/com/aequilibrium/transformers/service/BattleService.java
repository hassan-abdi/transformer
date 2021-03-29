package com.aequilibrium.transformers.service;

import com.aequilibrium.transformers.domain.BattleResult;
import com.aequilibrium.transformers.dto.BattleRequest;

public interface BattleService {
    BattleResult fight(BattleRequest request);
}
