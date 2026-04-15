package ru.olgrin.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.olgrin.usecase.SearchSimilarIncidentsUseCase;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SimilarIncidentsController {

    private final SearchSimilarIncidentsUseCase searchSimilarIncidentsUseCase;

    @PostMapping(path = "/incidents/similar", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<String>> getSimilarIncidents(
            @RequestBody String query,
            @RequestParam(defaultValue = "3") int limit){
        try {
            List<String> result = searchSimilarIncidentsUseCase.execute(query, limit);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
