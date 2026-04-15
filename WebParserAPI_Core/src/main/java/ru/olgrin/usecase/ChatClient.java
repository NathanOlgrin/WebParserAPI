package ru.olgrin.usecase;

public interface ChatClient {

    String execute(String getQuestion, Integer topK);
}
