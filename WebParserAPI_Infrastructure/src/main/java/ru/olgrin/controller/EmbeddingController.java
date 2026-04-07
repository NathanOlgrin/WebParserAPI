package ru.olgrin.controller;

import org.springframework.web.bind.annotation.*;
import ru.olgrin.usecase.CreateEmbeddingVectorsUseCase;

import java.util.List;

@RestController
public class EmbeddingController {

    private final CreateEmbeddingVectorsUseCase useCase;

    public EmbeddingController(CreateEmbeddingVectorsUseCase useCase) {
        this.useCase = useCase;
    }

    @GetMapping("/embeddings")
    public List<float[]> generate(@RequestParam List<String> text){
        return useCase.execute(text);
    }
}
