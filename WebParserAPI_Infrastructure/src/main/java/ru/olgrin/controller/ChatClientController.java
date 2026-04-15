package ru.olgrin.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.olgrin.QuestionRequest;
import ru.olgrin.usecase.ChatClient;

@RestController
@RequiredArgsConstructor
public class ChatClientController {

    private final ChatClient chatClientUseCase;

    @PostMapping("/ask")
    public ResponseEntity<String> ask(@RequestBody QuestionRequest request){
        System.out.println("REQUEST OBJECT: " + request);
        System.out.println("QUESTION: " + request.getQuestion());
        System.out.println("TOPK: " + request.getTopK());
        String answer = chatClientUseCase.execute(request.getQuestion(), request.getTopK());
        return ResponseEntity.ok(answer);
    }
}
