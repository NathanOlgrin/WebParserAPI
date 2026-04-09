package ru.olgrin.usecase;

import ru.olgrin.ports.out.model.VectorData;
import ru.olgrin.ports.out.model.VectorSaveResult;

import java.util.List;

public interface SaveVectorstToStore {

    VectorSaveResult execute(List<VectorData> embeddingVectors);
}
