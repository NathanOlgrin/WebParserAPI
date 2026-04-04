package ru.olgrin.domain.strategy;

import ru.olgrin.domain.config.ParserConfig;

public interface ParsingStrategy {
    boolean supports(String url);
    ParserConfig getConfig();
}
