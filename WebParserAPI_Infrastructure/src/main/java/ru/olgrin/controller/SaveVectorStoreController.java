package ru.olgrin.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.olgrin.mapper.VectorDataMapper;
import ru.olgrin.ports.out.model.VectorData;
import ru.olgrin.ports.out.model.VectorSaveResult;
import ru.olgrin.usecase.SaveEmbeddingVectorsUseCase;

import java.util.List;

@RestController
public class SaveVectorStoreController {

    public final SaveEmbeddingVectorsUseCase useCase;
    private final VectorDataMapper mapper;

    public SaveVectorStoreController(SaveEmbeddingVectorsUseCase saveEmbeddingVectorsUseCase, VectorDataMapper mapper) {
        this.useCase = saveEmbeddingVectorsUseCase;
        this.mapper = mapper;
    }

    @PostMapping("/save")
    public ru.olgrin.DTO.SaveVectorsResponse save(@RequestBody ru.olgrin.DTO.SaveVectorsRequest request){
        List<VectorData> data = mapper.toVectorData(request);
        VectorSaveResult result = useCase.execute(data);
        return mapper.toResponse(result);
    }
}
