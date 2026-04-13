package ru.olgrin.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import ru.olgrin.model.embeddings.RosbertaEmbeddingModel;
import ru.olgrin.ports.out.EmbeddingVectorsPort;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmbeddingVectorsService implements EmbeddingVectorsPort {

    private final RosbertaEmbeddingModel model;

    public EmbeddingVectorsService(RosbertaEmbeddingModel model) {
        this.model = model;
    }

    @Override
    public List<float[]> createEmbeddingVectors(List<String> text) {
        List<float[]> embeddingVectorsList = new ArrayList<>();
        for (int i = 0; i < text.size(); i++){
            embeddingVectorsList.add(model.embed(text.get(i)));
        }

        return embeddingVectorsList;
    }
}
