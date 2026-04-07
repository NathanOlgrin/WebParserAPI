package ru.olgrin.usecase;

import java.util.List;

public interface CreateEmbeddingVectors {

    List<float[]> execute(List<String> text);
}
