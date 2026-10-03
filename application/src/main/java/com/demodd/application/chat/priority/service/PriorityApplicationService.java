package com.demodd.application.chat.priority.service;

import com.demodd.application.chat.priority.dto.PriorityResponse;
import com.demodd.application.chat.priority.port.in.CreatePriorityUseCase;
import com.demodd.application.chat.priority.port.in.DeletePriorityUseCase;
import com.demodd.application.chat.priority.port.in.GetPriorityUseCase;
import com.demodd.application.chat.priority.port.in.UpdatePriorityUseCase;
import com.demodd.domain.chat.priority.exception.PriorityNotFoundException;
import com.demodd.domain.chat.priority.model.aggregate.Priority;
import com.demodd.domain.chat.priority.model.valueobject.PriorityId;
import com.demodd.domain.chat.priority.model.valueobject.PriorityName;
import com.demodd.domain.chat.priority.model.valueobject.PriorityStatus;
import com.demodd.domain.chat.priority.port.repository.PriorityRepositoryPort;

import java.util.List;
import java.util.UUID;

public class PriorityApplicationService implements
        CreatePriorityUseCase,
        UpdatePriorityUseCase,
        GetPriorityUseCase,
        DeletePriorityUseCase {

    private final PriorityRepositoryPort repository;

    public PriorityApplicationService(PriorityRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public PriorityResponse execute(String name) {
        Priority entity = Priority.create(PriorityName.of(name));
        Priority saved = repository.save(entity);
        return PriorityResponse.fromDomain(saved);
    }

    @Override
    public PriorityResponse execute(UUID id, String name, String status) {
        PriorityId entityId = PriorityId.of(id);
        Priority entity = repository.findById(entityId)
                .orElseThrow(() -> new PriorityNotFoundException(entityId));

        entity.update(PriorityName.of(name), PriorityStatus.of(status));
        Priority updated = repository.save(entity);
        return PriorityResponse.fromDomain(updated);
    }

    @Override
    public PriorityResponse getById(UUID id) {
        PriorityId entityId = PriorityId.of(id);
        return repository.findById(entityId)
                .map(PriorityResponse::fromDomain)
                .orElseThrow(() -> new PriorityNotFoundException(entityId));
    }

    @Override
    public List<PriorityResponse> getAll() {
        return repository.findAll().stream()
                .map(PriorityResponse::fromDomain)
                .toList();
    }

    @Override
    public void execute(UUID id) {
        PriorityId entityId = PriorityId.of(id);
        if (!repository.existsById(entityId)) {
            throw new PriorityNotFoundException(entityId);
        }
        repository.deleteById(entityId);
    }
}
