package ru.olgrin.usecase;

import ru.olgrin.ports.out.EmbeddingVectorsPort;

import java.util.List;

public class CreateEmbeddingVectorsUseCase implements CreateEmbeddingVectors{

    private final EmbeddingVectorsPort embeddingVectorsPort;

    public CreateEmbeddingVectorsUseCase(EmbeddingVectorsPort embeddingVectorsPort) {
        this.embeddingVectorsPort = embeddingVectorsPort;
    }

    @Override
    public List<float[]> execute(List<String> text) {
        return embeddingVectorsPort.createEmbeddingVectors(text);
    }
}
