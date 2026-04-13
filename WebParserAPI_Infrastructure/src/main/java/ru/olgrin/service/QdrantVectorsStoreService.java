package ru.olgrin.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.qdrant.QdrantVectorStore;
import org.springframework.stereotype.Service;
import ru.olgrin.ports.out.VectorStorePort;
import ru.olgrin.ports.out.model.VectorData;
import ru.olgrin.ports.out.model.VectorSaveResult;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class QdrantVectorsStoreService implements VectorStorePort {

    private final QdrantVectorStore vectorStore;

    public QdrantVectorsStoreService(QdrantVectorStore vectorStore) {
        this.vectorStore = vectorStore;
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
}
