package ru.olgrin.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.olgrin.ports.out.EmbeddingVectorsPort;
import ru.olgrin.usecase.CreateEmbeddingVectorsUseCase;

@Configuration
public class EmbeddingUseCaseConfig {

    @Bean
    public CreateEmbeddingVectorsUseCase createEmbeddingVectorsUseCase(EmbeddingVectorsPort embeddingVectorsPort){
        return new CreateEmbeddingVectorsUseCase(embeddingVectorsPort);
    }
}
