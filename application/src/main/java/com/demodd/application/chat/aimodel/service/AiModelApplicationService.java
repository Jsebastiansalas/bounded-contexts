package com.demodd.application.chat.aimodel.service;

import com.demodd.application.chat.aimodel.dto.AiModelResponse;
import com.demodd.application.chat.aimodel.port.in.CreateAiModelUseCase;
import com.demodd.application.chat.aimodel.port.in.DeleteAiModelUseCase;
import com.demodd.application.chat.aimodel.port.in.GetAiModelUseCase;
import com.demodd.application.chat.aimodel.port.in.UpdateAiModelUseCase;
import com.demodd.domain.chat.aimodel.exception.AiModelNotFoundException;
import com.demodd.domain.chat.aimodel.model.aggregate.AiModel;
import com.demodd.domain.chat.aimodel.model.valueobject.AiModelId;
import com.demodd.domain.chat.aimodel.model.valueobject.AiModelName;
import com.demodd.domain.chat.aimodel.model.valueobject.AiModelStatus;
import com.demodd.domain.chat.aimodel.port.repository.AiModelRepositoryPort;

import java.util.List;
import java.util.UUID;

public class AiModelApplicationService implements
        CreateAiModelUseCase,
        UpdateAiModelUseCase,
        GetAiModelUseCase,
        DeleteAiModelUseCase {

    private final AiModelRepositoryPort repository;

    public AiModelApplicationService(AiModelRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public AiModelResponse execute(String name) {
        AiModel entity = AiModel.create(AiModelName.of(name));
        AiModel saved = repository.save(entity);
        return AiModelResponse.fromDomain(saved);
    }

    @Override
    public AiModelResponse execute(UUID id, String name, String status) {
        AiModelId entityId = AiModelId.of(id);
        AiModel entity = repository.findById(entityId)
                .orElseThrow(() -> new AiModelNotFoundException(entityId));

        entity.update(AiModelName.of(name), AiModelStatus.of(status));
        AiModel updated = repository.save(entity);
        return AiModelResponse.fromDomain(updated);
    }

    @Override
    public AiModelResponse getById(UUID id) {
        AiModelId entityId = AiModelId.of(id);
        return repository.findById(entityId)
                .map(AiModelResponse::fromDomain)
                .orElseThrow(() -> new AiModelNotFoundException(entityId));
    }

    @Override
    public List<AiModelResponse> getAll() {
        return repository.findAll().stream()
                .map(AiModelResponse::fromDomain)
                .toList();
    }

    @Override
    public void execute(UUID id) {
        AiModelId entityId = AiModelId.of(id);
        if (!repository.existsById(entityId)) {
            throw new AiModelNotFoundException(entityId);
        }
        repository.deleteById(entityId);
    }
}
