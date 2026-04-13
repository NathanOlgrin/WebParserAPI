package ru.olgrin.model.embeddings;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
@FieldDefaults(level = AccessLevel.PRIVATE)
@EnableConfigurationProperties(HuggingFaceProperties.class)
public class RosbertaClientConfig {

    @Bean
    public RestClient ruEnHuggingFaceRestClient(HuggingFaceProperties properties){
        if (properties.getToken() == null || properties.getToken().isBlank()){
            throw new IllegalStateException("huggingface token is not set");
        }

        System.out.println("TOKEN = " + properties.getToken());
        System.out.println("URL = " + properties.getRosberta().getUrl());

        return RestClient.builder()
                .baseUrl(properties.getRosberta().getUrl())
                .requestInterceptor(((request, body, execution) ->
                {request.getHeaders().setBearerAuth(properties.getToken()); return execution.execute(request, body);
                }))
                .build();
    }
}
