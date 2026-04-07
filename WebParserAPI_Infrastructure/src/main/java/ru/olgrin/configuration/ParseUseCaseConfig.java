package ru.olgrin.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.olgrin.ports.out.ParserPort;
import ru.olgrin.usecase.ParseWebsite;
import ru.olgrin.usecase.ParseWebsiteUseCase;

@Configuration
public class ParseUseCaseConfig {

    @Bean
    public ParseWebsiteUseCase parseWebsiteUseCase(ParserPort parserPort){
        return new ParseWebsiteUseCase(parserPort);
    }
}
