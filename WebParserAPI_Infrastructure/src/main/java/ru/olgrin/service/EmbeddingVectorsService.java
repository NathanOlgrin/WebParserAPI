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
            List<Double> doubles = model.embed(text.get(i));
            float[] floatArray = new float[doubles.size()];
            for (int j = 0; j < doubles.size(); j++) {
                floatArray[j] = doubles.get(j).floatValue();
            }
            embeddingVectorsList.add(floatArray);
        }

        return embeddingVectorsList;
    }
}
