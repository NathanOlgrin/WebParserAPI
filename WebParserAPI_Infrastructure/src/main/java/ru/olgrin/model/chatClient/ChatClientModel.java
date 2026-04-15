package ru.olgrin.model.chatClient;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.document.Document;
import org.springframework.stereotype.Service;
import ru.olgrin.ports.out.ChatClientPort;
import ru.olgrin.ports.out.model.PreprocessedQuestion;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ChatClientModel implements ChatClientPort {

   private ChatClient client;

//    private static final String PREPROCESSED_SYSTEM_PROMPT =
//            "";                                                          - скорее всего не нужно, потому что описан в ядре.

    public ChatClientModel(ChatClient client) {
        this.client = client;
    }

    @Override
    public String getAnswer(String prompt) {
//        return "FAKE ANSWER: " + prompt;                                  - заглушка на случай, если токены закончились
        return client.prompt(prompt).call().content();
    }

    @Override
    public PreprocessedQuestion preprocess(String question) {
//        return new PreprocessedQuestion(List.of(question));               - заглушка на случай, если токены закончились
        if (question == null || question.isBlank()) {
            throw new IllegalArgumentException("Question must not be null or empty");
        }

        String raw = client.prompt(new Prompt(
                List.of(new UserMessage(question))
        )).call().content();
        return extractVariants(raw);
    }

    private PreprocessedQuestion extractVariants(String raw) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode node = mapper.readTree(raw);

            List<String> variants = new ArrayList<>();
            for (JsonNode v : node.get("variants")) {
                variants.add(v.asText());
            }

            return new PreprocessedQuestion(variants);

        } catch (Exception e) {
            throw new RuntimeException("Failed to parse LLM response", e);
        }
    }
}
