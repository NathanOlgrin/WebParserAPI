package ru.olgrin.domain;

public class Embedding {
    float[] vector;

    public Embedding(float[] vector) {
        this.vector = vector;
    }

    public float[] getVector() {
        return vector;
    }

    public void setVector(float[] vector) {
        this.vector = vector;
    }
}
