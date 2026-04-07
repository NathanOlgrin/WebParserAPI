package ru.olgrin.model.embeddings;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
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

@Service
@Primary
//@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RosbertaEmbeddingModel extends AbstractEmbeddingModel {

    private final RestClient restClient;

    public RosbertaEmbeddingModel(RestClient restClient) {
        this.restClient = restClient;
    }

    @Override
    public @NotNull EmbeddingResponse call(@NotNull EmbeddingRequest request) {
        var payload = Map.of(
                "inputs", "search_query: " + request.getInstructions().get(0),
                "parametrs",
                Map.of("pooling_method", "cls", "normalize_embeddings", true)
        );

        List<Double> responseList = restClient.post()
                .contentType(MediaType.APPLICATION_JSON)
                .body(payload)
                .retrieve()
                .body(new ParameterizedTypeReference<>() {});

        return new EmbeddingResponse(List.of(new Embedding(responseList, 0)));
    }



    @Override
    public List<Double> embed(String text) {
        return call(new EmbeddingRequest(Collections.singletonList(text), null))
                .getResult().getOutput();
    }

    @Override
    public @NotNull List<Double> embed(@NotNull Document document) {
        return call(new EmbeddingRequest(List.of(document.getFormattedContent()), null))
                .getResult().getOutput();
    }
}
