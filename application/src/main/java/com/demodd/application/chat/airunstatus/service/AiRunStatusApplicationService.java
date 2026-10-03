package com.demodd.application.chat.airunstatus.service;

import com.demodd.application.chat.airunstatus.dto.AiRunStatusResponse;
import com.demodd.application.chat.airunstatus.port.in.CreateAiRunStatusUseCase;
import com.demodd.application.chat.airunstatus.port.in.DeleteAiRunStatusUseCase;
import com.demodd.application.chat.airunstatus.port.in.GetAiRunStatusUseCase;
import com.demodd.application.chat.airunstatus.port.in.UpdateAiRunStatusUseCase;
import com.demodd.domain.chat.airunstatus.exception.AiRunStatusNotFoundException;
import com.demodd.domain.chat.airunstatus.model.aggregate.AiRunStatus;
import com.demodd.domain.chat.airunstatus.model.valueobject.AiRunStatusId;
import com.demodd.domain.chat.airunstatus.model.valueobject.AiRunStatusName;
import com.demodd.domain.chat.airunstatus.model.valueobject.AiRunStatusStatus;
import com.demodd.domain.chat.airunstatus.port.repository.AiRunStatusRepositoryPort;

import java.util.List;
import java.util.UUID;

public class AiRunStatusApplicationService implements
        CreateAiRunStatusUseCase,
        UpdateAiRunStatusUseCase,
        GetAiRunStatusUseCase,
        DeleteAiRunStatusUseCase {

    private final AiRunStatusRepositoryPort repository;

    public AiRunStatusApplicationService(AiRunStatusRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public AiRunStatusResponse execute(String name) {
        AiRunStatus entity = AiRunStatus.create(AiRunStatusName.of(name));
        AiRunStatus saved = repository.save(entity);
        return AiRunStatusResponse.fromDomain(saved);
    }

    @Override
    public AiRunStatusResponse execute(UUID id, String name, String status) {
        AiRunStatusId entityId = AiRunStatusId.of(id);
        AiRunStatus entity = repository.findById(entityId)
                .orElseThrow(() -> new AiRunStatusNotFoundException(entityId));

        entity.update(AiRunStatusName.of(name), AiRunStatusStatus.of(status));
        AiRunStatus updated = repository.save(entity);
        return AiRunStatusResponse.fromDomain(updated);
    }

    @Override
    public AiRunStatusResponse getById(UUID id) {
        AiRunStatusId entityId = AiRunStatusId.of(id);
        return repository.findById(entityId)
                .map(AiRunStatusResponse::fromDomain)
                .orElseThrow(() -> new AiRunStatusNotFoundException(entityId));
    }

    @Override
    public List<AiRunStatusResponse> getAll() {
        return repository.findAll().stream()
                .map(AiRunStatusResponse::fromDomain)
                .toList();
    }

    @Override
    public void execute(UUID id) {
        AiRunStatusId entityId = AiRunStatusId.of(id);
        if (!repository.existsById(entityId)) {
            throw new AiRunStatusNotFoundException(entityId);
        }
        repository.deleteById(entityId);
    }
}
