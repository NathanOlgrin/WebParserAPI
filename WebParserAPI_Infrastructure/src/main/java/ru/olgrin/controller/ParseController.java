package ru.olgrin.controller;

import org.springframework.web.bind.annotation.*;
import ru.olgrin.usecase.ParseWebsiteUseCase;


import java.util.List;

@RestController
public class ParseController {

    private final ParseWebsiteUseCase parseWebsiteUseCase;

    public ParseController(ParseWebsiteUseCase parseWebsiteUseCase) {
        this.parseWebsiteUseCase = parseWebsiteUseCase;
    }

    @GetMapping("/parse")
    public List<String> parse(@RequestParam String url) throws Exception {
        return parseWebsiteUseCase.execute(url);
    }
}
