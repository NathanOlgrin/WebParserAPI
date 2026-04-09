package ru.olgrin;

import java.util.List;

public class VectorItem {
    private String text;
    private List<Float> vector;

    public VectorItem(String text, List<Float> vector) {
        this.text = text;
        this.vector = vector;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Float> getVector() {
        return vector;
    }

    public void setVector(List<Float> vector) {
        this.vector = vector;
    }
}
