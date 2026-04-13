package ru.olgrin.controller;

import org.springframework.web.bind.annotation.*;
import ru.olgrin.ports.out.model.VectorSaveResult;
import ru.olgrin.usecase.SaveAndEmbedAndParseUseCase;

@RestController
public class SaveAndEmedAndParseController {

    private final SaveAndEmbedAndParseUseCase useCase;

    public SaveAndEmedAndParseController(SaveAndEmbedAndParseUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping("/parse-embeddings-save")
    public VectorSaveResult save(@RequestBody String url){
        return useCase.execute(url);
    }
}
