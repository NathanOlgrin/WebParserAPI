package ru.olgrin.usecase;

import org.springframework.stereotype.Service;
import ru.olgrin.ports.out.ParserPort;

import java.util.List;

@Service
public class ParseWebsiteUseCaseService implements ParseWebsiteUseCase{
    private final ParserPort parserPort;

    public ParseWebsiteUseCaseService(ParserPort parserPort) {
        this.parserPort = parserPort;
    }

    @Override
    public List<String> execute(String url) throws Exception {
        List<String> text = parserPort.parse(url);
        return text;
    }
}
