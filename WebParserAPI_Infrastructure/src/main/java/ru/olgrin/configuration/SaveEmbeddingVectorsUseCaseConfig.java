package ru.olgrin.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.olgrin.ports.out.VectorStorePort;
import ru.olgrin.usecase.SaveEmbeddingVectorsUseCase;

@Configuration
public class SaveEmbeddingVectorsUseCaseConfig {

    @Bean
    public SaveEmbeddingVectorsUseCase saveEmbeddingVectorsUseCase(VectorStorePort vectorStorePort){
        return new SaveEmbeddingVectorsUseCase(vectorStorePort);
    }
}
