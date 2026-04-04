package ru.olgrin;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"ru.olgrin.core", "ru.olgrin.infrastructure"})
public class WebParserAPICore {
    public static void main(String[] args){
        SpringApplication.run(WebParserAPICore.class, args);
    }
}