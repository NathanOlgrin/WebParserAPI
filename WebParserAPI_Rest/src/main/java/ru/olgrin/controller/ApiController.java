package ru.olgrin.controller;

import org.springframework.web.bind.annotation.*;
import ru.olgrin.QuestionRequest;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {
    private final InfrastructureClient client;

    public ApiController(InfrastructureClient client) {
        this.client = client;
    }


    @GetMapping("/parse")
    public List<String> parse(@RequestParam String url){
        return client.parse(url);
    }

    @GetMapping("/embeddings")
    public List<float[]> embed(@RequestParam List<String> text){
        return client.embed(text);
    }

    @GetMapping("/parse-embeddings")
    public List<float[]> parseAndEmbed(@RequestParam String url){
        return client.parseAndEmbed(url);
    }

    @PostMapping("/save")
    public ru.olgrin.DTO.SaveVectorsResponse saveVectors(@RequestBody ru.olgrin.DTO.SaveVectorsResponse vectors){
        return client.saveVectors(vectors);
    }

    @PostMapping("/parse-embeddings-save")
    public ru.olgrin.DTO.SaveVectorsResponse parseAndEmbedAndSaveVectors(@RequestBody ru.olgrin.DTO.SaveVectorsRequest request){
        return client.parseAndEmbedAndSaveVectors(request.getUrl());
    }

    @PostMapping(value = "/ask",
            consumes = "application/json;charset=UTF-8",
            produces = "application/json;charset=UTF-8")
    public String parseAndEmbedAndSaveVectors(@RequestBody QuestionRequest request){
        System.out.println("QUESTION RAW: " + request.getQuestion());
        System.out.println("QUESTION UTF8: " + new String(request.getQuestion().getBytes(StandardCharsets.UTF_8)));
        return client.askForChatClient(request);
    }
}
