package ru.olgrin.ports.out.model;

import java.util.List;

public class PreprocessedQuestion {

    private List<String> question;
    public PreprocessedQuestion(List<String> question){
        this.question = question;
    }

    public List<String> getQuestion() {
        return question;
    }
}
