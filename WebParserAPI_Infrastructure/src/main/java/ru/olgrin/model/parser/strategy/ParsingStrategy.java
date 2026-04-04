package ru.olgrin.model.parser.strategy;

import ru.olgrin.model.parser.config.ParserConfig;

public interface ParsingStrategy {
    boolean supports(String url);
    ParserConfig getConfig();
}
