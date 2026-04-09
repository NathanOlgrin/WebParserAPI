package ru.olgrin.mapper;

import org.springframework.stereotype.Component;
import ru.olgrin.VectorItem;
import ru.olgrin.domain.DocumentChunk;
import ru.olgrin.domain.Embedding;
import ru.olgrin.ports.out.model.VectorData;
import ru.olgrin.ports.out.model.VectorSaveResult;

import java.util.ArrayList;
import java.util.List;

@Component
public class VectorDataMapper {

    public List<VectorData> toVectorData(ru.olgrin.DTO.SaveVectorsRequest request) {

        List<VectorData> result = new ArrayList<>();

        for (int i = 0; i < request.getItems().size(); i++) {

            VectorItem item = request.getItems().get(i);

            DocumentChunk chunk = new DocumentChunk(
                    item.getText(),
                    request.getUrl(),
                    i
            );

            Embedding embedding = new Embedding(
                    toFloatArray(item.getVector())
            );

            result.add(new VectorData(chunk, embedding));
        }

        return result;
    }

    public ru.olgrin.DTO.SaveVectorsResponse toResponse(VectorSaveResult result) {
        return new ru.olgrin.DTO.SaveVectorsResponse(
                result.getSavedCount(),
                result.getFailedCount()
        );
    }

    private float[] toFloatArray(List<Float> list) {
        float[] array = new float[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }
}
