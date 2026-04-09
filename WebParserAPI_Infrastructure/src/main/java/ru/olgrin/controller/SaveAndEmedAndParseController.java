package ru.olgrin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.olgrin.ports.out.model.VectorSaveResult;
import ru.olgrin.usecase.SaveAndEmbedAndParseUseCase;

@RestController
public class SaveAndEmedAndParseController {

    private final SaveAndEmbedAndParseUseCase useCase;

    public SaveAndEmedAndParseController(SaveAndEmbedAndParseUseCase useCase) {
        this.useCase = useCase;
    }

    @GetMapping("/parse-embeddings-save")
    public VectorSaveResult save(@RequestParam String url){
        return useCase.execute(url);
    }
}
