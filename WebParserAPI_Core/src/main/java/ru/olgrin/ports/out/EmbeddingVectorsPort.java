package ru.olgrin.ports.out;

import java.util.List;

public interface EmbeddingVectorsPort {

    List<float[]> createEmbeddingVectors(List<String> text);
}
