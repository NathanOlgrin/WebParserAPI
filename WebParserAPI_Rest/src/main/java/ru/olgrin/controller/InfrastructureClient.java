package ru.olgrin.controller;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.olgrin.DTO.SaveVectorsResponse;
import ru.olgrin.QuestionRequest;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Component
public class InfrastructureClient {

    private final RestTemplate restTemplate;

    public InfrastructureClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<String> parse(String url) {
        return restTemplate.exchange(
                "/infrastructure/parse?url=" + url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<String>>() {}
        ).getBody();
    }

    public List<float[]> embed(List<String> texts) {
        return restTemplate.exchange(
                "/infrastructure/embeddings",
                HttpMethod.POST,
                new HttpEntity<>(texts),
                new ParameterizedTypeReference<List<float[]>>() {}
        ).getBody();
    }

    public List<float[]> parseAndEmbed(String url) {
        return restTemplate.exchange(
                "/infrastructure/parse-embeddings?url=" + url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<float[]>>() {}
        ).getBody();
    }

    public SaveVectorsResponse saveVectors(SaveVectorsResponse vectors){
        return restTemplate.exchange("/infrastructure/save",
                HttpMethod.POST,
                new HttpEntity<>(vectors),
                new ParameterizedTypeReference<ru.olgrin.DTO.SaveVectorsResponse>() {}
        ).getBody();
    }
    public SaveVectorsResponse parseAndEmbedAndSaveVectors(String url){
        return restTemplate.exchange("/infrastructure/parse-embeddings-save",
                HttpMethod.POST,
                new HttpEntity<>(url),
                new ParameterizedTypeReference<SaveVectorsResponse>() {}
        ).getBody();
    }

    public String askForChatClient(QuestionRequest questionRequest){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));

        HttpEntity<QuestionRequest> entity = new HttpEntity<>(questionRequest, headers);

        return restTemplate.exchange("/infrastructure/ask",
                HttpMethod.POST,
                entity,
                new ParameterizedTypeReference<String>() {}
        ).getBody();
    }

}
