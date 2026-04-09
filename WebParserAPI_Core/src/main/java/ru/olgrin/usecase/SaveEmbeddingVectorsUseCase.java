package ru.olgrin.usecase;

import ru.olgrin.ports.out.VectorStorePort;
import ru.olgrin.ports.out.model.VectorData;
import ru.olgrin.ports.out.model.VectorSaveResult;

import java.util.List;

public class SaveEmbeddingVectorsUseCase implements SaveVectorstToStore{

    private final VectorStorePort vectorStorePort;

    public SaveEmbeddingVectorsUseCase(VectorStorePort vectorStorePort) {
        this.vectorStorePort = vectorStorePort;
    }

    @Override
    public VectorSaveResult execute(List<VectorData> embeddingVectors) {
        return vectorStorePort.save(embeddingVectors);
    }
}
