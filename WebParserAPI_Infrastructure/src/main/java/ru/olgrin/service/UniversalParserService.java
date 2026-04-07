package ru.olgrin.service;

import org.springframework.stereotype.Service;
import ru.olgrin.model.parser.loader.JsoupPageLoader;
import ru.olgrin.model.parser.loader.PageLoader;
import ru.olgrin.model.parser.model.ParsedResult;
import ru.olgrin.model.parser.parser.UniversalParser;
import ru.olgrin.model.parser.pipeline.ParsingPipeline;
import ru.olgrin.model.parser.service.ParsingService;
import ru.olgrin.model.parser.strategy.MidRFSiteStrategy;
import ru.olgrin.model.parser.strategy.StrategyRegistry;
import ru.olgrin.ports.out.ParserPort;

import java.util.List;

@Service
public class UniversalParserService implements ParserPort {
    @Override
    public List<String> parse(String url) {
        PageLoader loader = new JsoupPageLoader();
        UniversalParser universalParser = new UniversalParser();
        ParsingPipeline pipeline = new ParsingPipeline(loader, universalParser);
        StrategyRegistry registry = new StrategyRegistry();
        registry.register(new MidRFSiteStrategy());
        ParsingService service = new ParsingService(pipeline, registry);
        try {
            ParsedResult result = service.parse(url);
            return result.get("text");
        } catch (Exception e){
            throw new RuntimeException("Failed to parse HTML", e);
        }
    }
}
