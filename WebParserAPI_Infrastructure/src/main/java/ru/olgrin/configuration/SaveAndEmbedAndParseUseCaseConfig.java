package ru.olgrin.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.olgrin.ports.out.EmbeddingVectorsPort;
import ru.olgrin.ports.out.ParserPort;
import ru.olgrin.ports.out.VectorStorePort;
import ru.olgrin.usecase.CreateEmbeddingVectors;
import ru.olgrin.usecase.SaveAndEmbedAndParseUseCase;

@Configuration
public class SaveAndEmbedAndParseUseCaseConfig {

    @Bean
    public SaveAndEmbedAndParseUseCase saveAndEmbedAndParseUseCase(VectorStorePort vectorStorePort, CreateEmbeddingVectors createEmbeddingVectors, ParserPort parserPort){
        return  new SaveAndEmbedAndParseUseCase(parserPort, createEmbeddingVectors, vectorStorePort);
    }
}
