package ru.olgrin.usecase;

import ru.olgrin.ports.out.ParserPort;

import java.util.List;

public class ParseWebsiteUseCase implements ParseWebsite{
    private final ParserPort parserPort;

    public ParseWebsiteUseCase(ParserPort parserPort) {
        this.parserPort = parserPort;
    }

    public List<String> execute(String url) throws Exception {
        List<String> text = parserPort.parse(url);
        return text;
    }
}
