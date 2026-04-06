package ru.olgrin.model.embeddings;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.ai.document.Document;
import org.springframework.ai.embedding.AbstractEmbeddingModel;
import org.springframework.ai.embedding.Embedding;
import org.springframework.ai.embedding.EmbeddingRequest;
import org.springframework.ai.embedding.EmbeddingResponse;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RosbertaEmbeddingModel extends AbstractEmbeddingModel {

    RestClient restClient;
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
    public @NotNull List<Double> embed(@NotNull Document document) {
        return call(new EmbeddingRequest(List.of(document.getFormattedContent()), null))
                .getResult().getOutput();
    }
}
