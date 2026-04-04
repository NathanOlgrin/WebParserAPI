package ru.olgrin.model.parser.pipeline;

import ru.olgrin.model.parser.config.ParserConfig;
import ru.olgrin.model.parser.loader.PageLoader;
import ru.olgrin.model.parser.model.ParsedResult;
import ru.olgrin.model.parser.parser.UniversalParser;
import ru.olgrin.model.parser.loader.PageLoader;

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
