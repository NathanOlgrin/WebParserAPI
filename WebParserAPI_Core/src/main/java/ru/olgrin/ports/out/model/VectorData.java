package ru.olgrin.ports.out.model;

import ru.olgrin.domain.DocumentChunk;
import ru.olgrin.domain.Embedding;

public class VectorData {
    DocumentChunk documentChunk;
    Embedding embedding;

    public VectorData(DocumentChunk documentChunk, Embedding embedding) {
        this.documentChunk = documentChunk;
        this.embedding = embedding;
    }

    public DocumentChunk getDocumentChunk() {
        return documentChunk;
    }

    public void setDocumentChunk(DocumentChunk documentChunk) {
        this.documentChunk = documentChunk;
    }

    public Embedding getEmbedding() {
        return embedding;
    }

    public void setEmbedding(Embedding embedding) {
        this.embedding = embedding;
    }
}
