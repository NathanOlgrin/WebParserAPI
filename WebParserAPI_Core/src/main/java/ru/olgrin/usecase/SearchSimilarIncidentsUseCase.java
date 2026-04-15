package ru.olgrin.usecase;

import ru.olgrin.ports.out.VectorStorePort;
import ru.olgrin.ports.out.model.VectorDocument;

import java.util.List;

public class SearchSimilarIncidentsUseCase{

    private final VectorStorePort vectorStorePort;

    public SearchSimilarIncidentsUseCase(VectorStorePort vectorStorePort) {
        this.vectorStorePort = vectorStorePort;
    }

    public List<String> execute(String query, int limit) {
        return vectorStorePort.search(query, limit)
                .stream()
                .map(VectorDocument::getContent)
                .toList();
    }
}
