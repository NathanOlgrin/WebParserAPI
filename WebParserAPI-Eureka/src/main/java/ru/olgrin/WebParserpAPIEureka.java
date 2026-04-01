package ru.olgrin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class WebParserpAPIEureka {
    public static void main(String[] args) {
        SpringApplication.run(WebParserpAPIEureka.class, args);
    }
}