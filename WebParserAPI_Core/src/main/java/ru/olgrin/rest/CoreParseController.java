package ru.olgrin.rest;

import org.springframework.web.bind.annotation.*;
import ru.olgrin.usecase.ParseWebsiteUseCaseService;

import java.util.List;

@RestController
//@RequestMapping("/core")
public class CoreParseController {

    private final ParseWebsiteUseCaseService parseWebsiteUseCase;

    public CoreParseController(ParseWebsiteUseCaseService parseWebsiteUseCase) {
        this.parseWebsiteUseCase = parseWebsiteUseCase;
    }

    @GetMapping("/parse")
    public List<String> parse(@RequestParam String url) throws Exception {
        return parseWebsiteUseCase.execute(url);
    }
}
