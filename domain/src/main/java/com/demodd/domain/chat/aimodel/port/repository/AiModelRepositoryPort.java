package com.demodd.domain.chat.aimodel.port.repository;

import com.demodd.domain.chat.aimodel.model.aggregate.AiModel;
import com.demodd.domain.chat.aimodel.model.valueobject.AiModelId;

import java.util.List;
import java.util.Optional;

public interface AiModelRepositoryPort {

    AiModel save(AiModel entity);

    Optional<AiModel> findById(AiModelId id);

    List<AiModel> findAll();

    void deleteById(AiModelId id);

    boolean existsById(AiModelId id);
}
