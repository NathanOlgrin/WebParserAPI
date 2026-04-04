package ru.olgrin.model.parser.service;

import ru.olgrin.model.parser.model.ParsedResult;
import ru.olgrin.model.parser.pipeline.ParsingPipeline;
import ru.olgrin.model.parser.strategy.ParsingStrategy;
import ru.olgrin.model.parser.strategy.StrategyRegistry;

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
