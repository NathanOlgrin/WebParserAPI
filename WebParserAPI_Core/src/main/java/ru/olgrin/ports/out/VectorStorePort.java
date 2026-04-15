package ru.olgrin.ports.out;

import ru.olgrin.ports.out.model.VectorData;
import ru.olgrin.ports.out.model.VectorDocument;
import ru.olgrin.ports.out.model.VectorSaveResult;

import java.util.List;

public interface VectorStorePort {

    VectorSaveResult save(List<VectorData> embeddingVectors);
    List<VectorDocument> search(String query, Integer topK);
}
