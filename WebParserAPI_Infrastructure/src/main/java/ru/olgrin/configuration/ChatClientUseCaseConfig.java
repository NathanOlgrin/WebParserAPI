package ru.olgrin.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.olgrin.PromptBuilder;
import ru.olgrin.ports.out.ChatClientPort;
import ru.olgrin.ports.out.VectorStorePort;
import ru.olgrin.usecase.ChatClient;
import ru.olgrin.usecase.ChatClientUseCase;

@Configuration
public class ChatClientUseCaseConfig {

    @Bean
    public PromptBuilder promptBuilder(){
        return new PromptBuilder();
    }

    @Bean
    public ChatClient chatClientUseCase(ChatClientPort chatClientPort, VectorStorePort vectorStorePort, PromptBuilder promptBuilder) {
        return new ChatClientUseCase(
                chatClientPort, vectorStorePort, promptBuilder);
    }
}
