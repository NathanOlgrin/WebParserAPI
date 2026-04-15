package ru.olgrin.model.chatClient;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatClientConfig {

    @Bean
    public ChatClient client(ChatClient.Builder builder){
        return builder.defaultAdvisors(new SimpleLoggerAdvisor()).build();
    }

    @Bean
    public ChatClientModel chatClientModel(ChatClient client){
        return new ChatClientModel(client);
    }

}