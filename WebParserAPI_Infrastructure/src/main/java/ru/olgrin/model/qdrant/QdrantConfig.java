package ru.olgrin.model.qdrant;

import io.qdrant.client.QdrantClient;
import io.qdrant.client.QdrantGrpcClient;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.vectorstore.qdrant.QdrantVectorStore;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import ru.olgrin.model.embeddings.RosbertaEmbeddingModel;
import org.springframework.beans.factory.annotation.Value;

@Slf4j
@Configuration
@FieldDefaults(level= AccessLevel.PRIVATE)
@EnableConfigurationProperties(QdrantProperties.class)
public class QdrantConfig {

    @Bean
    @Primary
    public QdrantClient qdrantClient(QdrantProperties properties){
        QdrantGrpcClient.Builder builder = QdrantGrpcClient.newBuilder(properties.getHost(), properties.getPort(), false);
        if (properties.getApiKey() != null && !properties.getApiKey().trim().isEmpty()){
            builder.withApiKey(properties.getApiKey());
        }
        return new QdrantClient(builder.build());
    }

    @Bean
    @Primary
    public QdrantVectorStore qdrantVectorStore(QdrantClient qdrantClient, RosbertaEmbeddingModel rosbertaEmbeddingModel, QdrantProperties properties){

        return QdrantVectorStore.builder(qdrantClient, rosbertaEmbeddingModel)
                .collectionName(properties.getCollectionName())
                .initializeSchema(true)
                .build();
    }
}
