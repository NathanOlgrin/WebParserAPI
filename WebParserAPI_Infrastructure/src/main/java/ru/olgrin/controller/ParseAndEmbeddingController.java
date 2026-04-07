package ru.olgrin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.olgrin.usecase.ParseAndEmbedUseCase;

import java.util.List;

@RestController
public class ParseAndEmbeddingController {
    private ParseAndEmbedUseCase parseAndEmbedUseCase;

    public ParseAndEmbeddingController(ParseAndEmbedUseCase parseAndEmbedUseCase) {
        this.parseAndEmbedUseCase = parseAndEmbedUseCase;
    }

    @GetMapping("/parse-and-embeddings")
    public List<float[]> generate(@RequestParam String url) throws Exception {
        return parseAndEmbedUseCase.execute(url);
    }
}