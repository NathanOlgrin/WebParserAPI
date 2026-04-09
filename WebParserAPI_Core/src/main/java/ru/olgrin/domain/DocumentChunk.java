package ru.olgrin.domain;

public class DocumentChunk {
    String text;
    int index;
    String url;

    public DocumentChunk(String text, String url, int index) {
        this.text = text;
        this.url = url;
        this.index = index;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
