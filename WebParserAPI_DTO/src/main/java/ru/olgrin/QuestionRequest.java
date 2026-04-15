package ru.olgrin;

public class QuestionRequest {
    private String question;
    private Integer topK;

    public QuestionRequest(String question, Integer topK) {
        this.question = question;
        this.topK = topK;
    }

    public QuestionRequest() {
    }

    public String getQuestion() {
        return question;
    }

    public Integer getTopK() {
        return topK;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setTopK(Integer topK) {
        this.topK = topK;
    }
}
