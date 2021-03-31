package com.aequilibrium.transformers.service.implementation;

import com.aequilibrium.transformers.domain.*;
import com.aequilibrium.transformers.dto.BattleRequest;
import com.aequilibrium.transformers.service.BattleService;
import com.aequilibrium.transformers.service.EventPublisher;
import com.aequilibrium.transformers.service.TransformerService;
import com.aequilibrium.transformers.service.TransformsComparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.INTERFACES)
public class BattleServiceImpl implements BattleService {
    private Team autobots;
    private Team decepticons;
    private final List<TransformerBattle> battles = new ArrayList<>();
    private final TransformsComparator comparator;
    private final TransformerService transformerService;
    private final EventPublisher publisher;

    @Autowired
    public BattleServiceImpl(TransformsComparator comparator, TransformerService transformerService, EventPublisher publisher) {
        this.comparator = comparator;
        this.transformerService = transformerService;
        this.publisher = publisher;
    }

    @Override
    public BattleResult fight(BattleRequest request) {
        setup(request);
        publisher.publish(new BattleEvent(BattleEvent.Type.START));
        IntStream.range(0, Math.min(autobots.getMembers().size(), decepticons.getMembers().size()))
                .forEach(index -> {
                    Transformer autobot = autobots.getMembers().get(index);
                    Transformer decepticon = decepticons.getMembers().get(index);
                    BattleStatus status = comparator.compare(autobot, decepticon);
                    updateStatus(autobot, decepticon, status);
                });
        publisher.publish(new BattleEvent(BattleEvent.Type.END));
        return buildResult();
    }

    private void setup(BattleRequest request) {
        autobots = Team.autobots(request.getAutobots().getName(), getMembers(request.getAutobots().getMembers()));
        decepticons = Team.decepticons(request.getDecepticons().getName(), getMembers(request.getDecepticons().getMembers()));
        publisher.publish(new BattleEvent(BattleEvent.Type.SETUP));
    }

    private List<Transformer> getMembers(List<Long> ids) {
        return ids.stream()
                .map(transformerService::get)
                .sorted((o1, o2) -> o2.getRank().compareTo(o1.getRank()))
                .collect(Collectors.toList());
    }

    public void updateStatus(Transformer autobot, Transformer decepticon, BattleStatus status) {
        battles.add(new TransformerBattle(autobot, decepticon, status));
    }

    private BattleResult buildResult() {
        List<TransformerBattle> autobotsWins = filterBattles(BattleStatus.AUTOBOT);
        List<TransformerBattle> deceptionsWins = filterBattles(BattleStatus.DECEPTICON);
        if (autobotsWins.size() > deceptionsWins.size()) {
            publisher.publish(new BattleEvent.WinnerEvent(autobots));
            return new BattleResult(battles.size(), autobots,
                    deceptionsWins.stream().map(TransformerBattle::getDecepticon).collect(Collectors.toList())
            );
        } else if (deceptionsWins.size() > autobotsWins.size()) {
            publisher.publish(new BattleEvent.WinnerEvent(decepticons));
            return new BattleResult(battles.size(), decepticons,
                    autobotsWins.stream().map(TransformerBattle::getDecepticon).collect(Collectors.toList())
            );
        }
        return BattleResult.tie(battles.size());
    }

    private List<TransformerBattle> filterBattles(BattleStatus status) {
        return battles.stream()
                .filter(battle -> battle.getStatus().equals(status))
                .collect(Collectors.toList());
    }
}