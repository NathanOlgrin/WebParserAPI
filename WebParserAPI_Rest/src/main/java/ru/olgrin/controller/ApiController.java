package ru.olgrin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {
    private final RestTemplate restTemplate = new RestTemplate();
    private final String coreUrl = "http://localhost:8080/core/parse";

    @GetMapping("/parse")
    public List<String> parse(@RequestParam String url){
        return restTemplate.getForObject(coreUrl + "?url=" + url, List.class);
    }
}
