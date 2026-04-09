package ru.olgrin.DTO;

import ru.olgrin.VectorItem;

import java.util.List;

public class SaveVectorsRequest {
    private String url;
    private List<VectorItem> items;

    public SaveVectorsRequest(String url, List<VectorItem> items) {
        this.url = url;
        this.items = items;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<VectorItem> getItems() {
        return items;
    }

    public void setItems(List<VectorItem> items) {
        this.items = items;
    }
}
