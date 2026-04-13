package ru.olgrin.controller;

import org.springframework.web.bind.annotation.*;

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
}
