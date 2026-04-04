package ru.olgrin.domain.strategy;

import ru.olgrin.domain.config.ParserConfig;

import java.util.HashMap;
import java.util.Map;

public class MidRFSiteStrategy implements ParsingStrategy{
    @Override
    public boolean supports(String url) {
        return url.contains(url);
    }

    @Override
    public ParserConfig getConfig() {
        Map<String, String> selectors = new HashMap<>();
        selectors.put("text","div.news-line__list-wrapper > ul > li > a");
        ParserConfig config = new ParserConfig(selectors);
        return config;
    }
}
