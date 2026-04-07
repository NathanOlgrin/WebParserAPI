package ru.olgrin.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.olgrin.ports.out.EmbeddingVectorsPort;
import ru.olgrin.ports.out.ParserPort;
import ru.olgrin.usecase.CreateEmbeddingVectors;
import ru.olgrin.usecase.ParseAndEmbedUseCase;
import ru.olgrin.usecase.ParseWebsite;

@Configuration
public class ParseAndEmbedUseCaseConfig {

    @Bean
    public ParseAndEmbedUseCase parseAndEmbedUseCase(ParserPort parserPort, CreateEmbeddingVectors createEmbeddingVectors){
        return new ParseAndEmbedUseCase(parserPort, createEmbeddingVectors);
    }
}
