package ru.olgrin.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.olgrin.ports.out.VectorStorePort;
import ru.olgrin.ports.out.model.VectorDocument;
import ru.olgrin.usecase.SearchSimilarIncidentsUseCase;

@Configuration
public class SearchSimilarIncidentUseCaseConfig {

    @Bean
    public SearchSimilarIncidentsUseCase searchSimilarIncidentsUseCase(VectorStorePort vectorStorePort){
        return new SearchSimilarIncidentsUseCase(vectorStorePort);
    }
}
