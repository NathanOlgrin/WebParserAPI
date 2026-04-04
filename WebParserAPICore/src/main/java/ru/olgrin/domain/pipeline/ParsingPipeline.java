package ru.olgrin.domain.pipeline;

import ru.olgrin.domain.config.ParserConfig;
import ru.olgrin.domain.loader.PageLoader;
import ru.olgrin.domain.model.ParsedResult;
import ru.olgrin.domain.parser.UniversalParser;

public class ParsingPipeline {

    private PageLoader loader;
    private UniversalParser parser;

    public ParsingPipeline(PageLoader loader, UniversalParser parser) {
        this.loader = loader;
        this.parser = parser;
    }

    public ParsedResult execute(String url, ParserConfig config) throws Exception {
        return parser.parse(loader.load(url), config);
    }
}
