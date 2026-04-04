package ru.olgrin.domain.service;

import ru.olgrin.domain.model.ParsedResult;
import ru.olgrin.domain.pipeline.ParsingPipeline;
import ru.olgrin.domain.strategy.ParsingStrategy;
import ru.olgrin.domain.strategy.StrategyRegistry;

public class ParsingService {

    private ParsingPipeline pipeline;
    private StrategyRegistry registry;

    public ParsingService(ParsingPipeline pipeline, StrategyRegistry registry) {
        this.pipeline = pipeline;
        this.registry = registry;
    }

    public ParsedResult parse(String url) throws Exception {
        ParsingStrategy strategy = registry.find(url);
        return pipeline.execute(url, strategy.getConfig());
    }
}
