package ru.olgrin.model.parser.parser;

import ru.olgrin.model.parser.config.ParserConfig;
import ru.olgrin.model.parser.model.ParsedResult;
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
