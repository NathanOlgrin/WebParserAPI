package ru.olgrin.ports.out.model;

public class VectorDocument {
    private String id;
    private String content;
    private double score;

    public VectorDocument(String id, String content, double score) {
        this.id = id;
        this.content = content;
        this.score = score;
    }

    public String getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public double getScore() {
        return score;
    }
}
