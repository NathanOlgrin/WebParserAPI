package ru.olgrin;

import ru.olgrin.domain.loader.JsoupPageLoader;
import ru.olgrin.domain.loader.PageLoader;
import ru.olgrin.domain.model.ParsedResult;
import ru.olgrin.domain.parser.UniversalParser;
import ru.olgrin.domain.pipeline.ParsingPipeline;
import ru.olgrin.domain.service.ParsingService;
import ru.olgrin.domain.strategy.MidRFSiteStrategy;
import ru.olgrin.domain.strategy.StrategyRegistry;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        PageLoader loader = new JsoupPageLoader();
        UniversalParser parser = new UniversalParser();
        ParsingPipeline pipeline = new ParsingPipeline(loader, parser);
        StrategyRegistry registry = new StrategyRegistry();
        registry.register(new MidRFSiteStrategy());

        ParsingService service = new ParsingService(pipeline, registry);
        ParsedResult result = service.parse("https://mid.ru/");
        List<String> list = result.get("text");
        System.out.println(list.get(0));
    }
}