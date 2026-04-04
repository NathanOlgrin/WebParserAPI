package ru.olgrin.domain.parser;

import ru.olgrin.domain.config.ParserConfig;
import ru.olgrin.domain.model.ParsedResult;
import org.jsoup.Jsoup;

public class UniversalParser {

    public ParsedResult parse(String html, ParserConfig config){
        ParsedResult result = new ParsedResult();

        for (var entry:config.getSelectors().entrySet()){
            result.put(entry.getKey(), Jsoup.parse(html).select(entry.getValue()).eachText());
        }

        return result;
    }
}
