package ru.olgrin.domain.strategy;

import java.util.ArrayList;
import java.util.List;

public class StrategyRegistry {
    private List<ParsingStrategy> strategies = new ArrayList<>();

    public void register(ParsingStrategy strategy){
        strategies.add(strategy);
    }

    public ParsingStrategy find(String url) {
        return strategies.stream()
                .filter(s -> s.supports(url))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No stratery found"));
    }
}
