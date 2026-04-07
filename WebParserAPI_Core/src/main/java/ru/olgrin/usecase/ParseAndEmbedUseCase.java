package ru.olgrin.usecase;

import ru.olgrin.ports.out.ParserPort;

import java.util.List;

public class ParseAndEmbedUseCase {

    private final ParserPort parserPort;
    private final CreateEmbeddingVectors createEmbeddingVectors;

    public ParseAndEmbedUseCase(ParserPort parserPort, CreateEmbeddingVectors createEmbeddingVectors) {
        this.parserPort = parserPort;
        this.createEmbeddingVectors = createEmbeddingVectors;
    }

    public List<float[]> execute (String url) throws Exception {
        return createEmbeddingVectors.execute(parserPort.parse(url));
    }
}
