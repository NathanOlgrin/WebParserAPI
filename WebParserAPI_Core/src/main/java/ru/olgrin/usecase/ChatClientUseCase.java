package ru.olgrin.usecase;

import ru.olgrin.PromptBuilder;
import ru.olgrin.ports.out.ChatClientPort;
import ru.olgrin.ports.out.VectorStorePort;
import ru.olgrin.ports.out.model.PreprocessedQuestion;
import ru.olgrin.ports.out.model.VectorDocument;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ChatClientUseCase implements ChatClient{

    private final ChatClientPort chatClientPort;
    private final VectorStorePort vectorStorePort;

    private final PromptBuilder promptBuilder;

    public ChatClientUseCase(ChatClientPort chatClientPort, VectorStorePort vectorStorePort, PromptBuilder promptBuilder) {
        this.chatClientPort = chatClientPort;
        this.vectorStorePort = vectorStorePort;
        this.promptBuilder = promptBuilder;
    }

    @Override
    public String execute(String getQuestion, Integer topK) {
        System.out.println("From ChatClientUseCase QUESTION: " + getQuestion);
        PreprocessedQuestion preprocessedQuestion = chatClientPort.preprocess(getQuestion);
        List<VectorDocument> documents = preprocessedQuestion.getQuestion().stream()
                .flatMap(v -> vectorStorePort.search(v, topK).stream())
                .toList();

        List<VectorDocument> rankedDocuments = rankDocuments(documents);

        List<String> context = documents.stream()
                .map(VectorDocument::getContent)
                .distinct()
                .limit(5)
                .toList();
        String prompt = promptBuilder.build(getQuestion, context);
        String answer = chatClientPort.getAnswer(prompt);
        return answer;
    }

    private List<VectorDocument> rankDocuments(List<VectorDocument> documents){
        Map<String, VectorDocument> uniqueDocs = documents.stream()
                .collect(Collectors.toMap(
                        VectorDocument::getId,
                        d -> d,
                        (d1, d2) -> d1.getScore() >= d2.getScore() ? d1 : d2
                ));

        List<VectorDocument> ranked = uniqueDocs.values().stream()
                .sorted(Comparator.comparingDouble(VectorDocument::getScore).reversed())
                .toList();
        return ranked;
    }
}
