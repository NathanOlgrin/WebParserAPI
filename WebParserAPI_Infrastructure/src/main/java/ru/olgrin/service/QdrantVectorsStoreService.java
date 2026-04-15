package ru.olgrin.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.qdrant.QdrantVectorStore;
import org.springframework.stereotype.Service;
import ru.olgrin.ports.out.VectorStorePort;
import ru.olgrin.ports.out.model.VectorData;
import ru.olgrin.ports.out.model.VectorDocument;
import ru.olgrin.ports.out.model.VectorSaveResult;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class QdrantVectorsStoreService implements VectorStorePort {

    private final QdrantVectorStore vectorStore;

    private final IncidentEmbeddingService incidentEmbeddingService;

    public QdrantVectorsStoreService(QdrantVectorStore vectorStore, IncidentEmbeddingService incidentEmbeddingService) {
        this.vectorStore = vectorStore;
        this.incidentEmbeddingService = incidentEmbeddingService;
    }

    @Override
    public VectorSaveResult save(List<VectorData> data) {
        try {
            vectorStore.add(
                    data.stream()
                            .map(d -> new Document(
                                    d.getDocumentChunk().getText(),
                                    Map.of(
                                            "url", d.getDocumentChunk().getUrl(),
                                            "index", d.getDocumentChunk().getIndex()
                                    )
                            ))
                            .toList()
            );
            log.info("Documents size: {}", data.size());
            return new VectorSaveResult(data.size(), 0);

        } catch (Exception e) {
            log.error("Error saving vectors to Qdrant ", e);
            throw e;
        }
    }

    @Override
    public List<VectorDocument> search(String query, Integer topK) {
        System.out.println("Question: " + query +"; topK: " + topK);
        List<Document> results = incidentEmbeddingService.searchSimilarIncidents(query, topK);
        System.out.println("Results: " + results.get(0).getText());
        return results.stream()
                .map(d -> new VectorDocument(
                        d.getId(),
                        d.getText(),
                        d.getScore()
                ))
                .toList();
    }
}
