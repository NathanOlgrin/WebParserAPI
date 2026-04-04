package ru.olgrin.domain.config;

import java.util.Map;

public class ParserConfig {
    private Map<String,String> selectors;

    public ParserConfig(Map<String, String> selectors) {
        this.selectors = selectors;
    }

    public void setSelectors(Map<String, String> selectors) {
        this.selectors = selectors;
    }

    public Map<String, String> getSelectors() {
        return selectors;
    }
}
