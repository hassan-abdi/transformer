package com.ha.transformers.service;

import com.ha.transformers.domain.BattleResult;
import com.ha.transformers.dto.BattleRequest;

public interface BattleService {
    BattleResult fight(BattleRequest request);
}
