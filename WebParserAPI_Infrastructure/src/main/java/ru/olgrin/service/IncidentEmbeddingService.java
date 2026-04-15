package ru.olgrin.service;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.qdrant.QdrantVectorStore;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IncidentEmbeddingService {

    private final QdrantVectorStore qdrantVectorStore;

    public List<Document> searchSimilarIncidents(String query, Integer limit){
        System.out.println("QUERY: " + query);
        System.out.println("LIMIT: " + limit);
        SearchRequest searchRequest  = SearchRequest.builder()
                .query(query)
                .topK(limit)
                .build();

        return qdrantVectorStore.similaritySearch(searchRequest);
    }

}
