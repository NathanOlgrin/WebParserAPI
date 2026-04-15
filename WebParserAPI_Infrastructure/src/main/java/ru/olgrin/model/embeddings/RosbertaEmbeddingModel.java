package ru.olgrin.model.embeddings;

import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.document.Document;
import org.springframework.ai.embedding.*;
import org.springframework.context.annotation.Primary;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@Primary
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RosbertaEmbeddingModel extends AbstractEmbeddingModel {

    private final RestClient restClient;

    public RosbertaEmbeddingModel(RestClient restClient) {
        this.restClient = restClient;
    }

    @Override
    public @NotNull EmbeddingResponse call(@NotNull EmbeddingRequest request) {
        List<String> inputs = request.getInstructions();

        if (inputs == null || inputs.isEmpty()) {
            throw new IllegalArgumentException("Empty embedding request");
        }

        List<Embedding> embeddings = inputs.stream()
                .map(text -> {
                    var payload = Map.of("inputs", text);

                    List<Double> embedding = restClient.post()
                            .contentType(MediaType.APPLICATION_JSON)
                            .body(payload)
                            .retrieve()
                            .body(new ParameterizedTypeReference<List<Double>>() {
                            });

                    float[] result = new float[embedding.size()];
                    for (int i = 0; i < embedding.size(); i++) {
                        result[i] = embedding.get(i).floatValue();
                    }

                    return new Embedding(result, 0);
                })
                .toList();

        log.info("Embedding size: {}", embeddings.size());

        return new EmbeddingResponse(embeddings);
    }



    @Override
    public float[] embed(String text) {
        System.out.println("Embedding text: " + text);
        return call(new EmbeddingRequest(Collections.singletonList(text), null))
                .getResult().getOutput();
    }

    @Override
    public float[] embed(@NotNull Document document) {
        System.out.println("Embedding text: " + document.getText());
        return call(new EmbeddingRequest(List.of(document.getFormattedContent()), null))
                .getResult().getOutput();
    }
}
