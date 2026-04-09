package ru.olgrin.usecase;

import ru.olgrin.domain.DocumentChunk;
import ru.olgrin.domain.Embedding;
import ru.olgrin.ports.out.ParserPort;
import ru.olgrin.ports.out.VectorStorePort;
import ru.olgrin.ports.out.model.VectorData;
import ru.olgrin.ports.out.model.VectorSaveResult;

import java.util.ArrayList;
import java.util.List;

public class SaveAndEmbedAndParseUseCase {

    private final ParserPort parserPort;
    private final CreateEmbeddingVectors createEmbeddingVectors;

    private final VectorStorePort vectorStorePort;

    public SaveAndEmbedAndParseUseCase(ParserPort parserPort, CreateEmbeddingVectors createEmbeddingVectors, VectorStorePort vectorStorePort) {
        this.parserPort = parserPort;
        this.createEmbeddingVectors = createEmbeddingVectors;
        this.vectorStorePort = vectorStorePort;
    }

    public VectorSaveResult execute(String url){
        List<String> texts = parserPort.parse(url);
        List<float[]> embeddingsVector = createEmbeddingVectors.execute(texts);
        List<VectorData> vectorDataList = new ArrayList<>();
        for(int i = 0; i<texts.size();i++){
            DocumentChunk chunk = new DocumentChunk(texts.get(i), url, i);
            Embedding embedding = new Embedding(embeddingsVector.get(i));
            vectorDataList.add(new VectorData(chunk, embedding));
        }
        return vectorStorePort.save(vectorDataList);
    }
}
