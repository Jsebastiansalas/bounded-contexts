package com.demodd.application.chat.escalationstatus.service;

import com.demodd.application.chat.escalationstatus.dto.EscalationStatusResponse;
import com.demodd.application.chat.escalationstatus.port.in.CreateEscalationStatusUseCase;
import com.demodd.application.chat.escalationstatus.port.in.DeleteEscalationStatusUseCase;
import com.demodd.application.chat.escalationstatus.port.in.GetEscalationStatusUseCase;
import com.demodd.application.chat.escalationstatus.port.in.UpdateEscalationStatusUseCase;
import com.demodd.domain.chat.escalationstatus.exception.EscalationStatusNotFoundException;
import com.demodd.domain.chat.escalationstatus.model.aggregate.EscalationStatus;
import com.demodd.domain.chat.escalationstatus.model.valueobject.EscalationStatusId;
import com.demodd.domain.chat.escalationstatus.model.valueobject.EscalationStatusName;
import com.demodd.domain.chat.escalationstatus.model.valueobject.EscalationStatusStatus;
import com.demodd.domain.chat.escalationstatus.port.repository.EscalationStatusRepositoryPort;

import java.util.List;
import java.util.UUID;

public class EscalationStatusApplicationService implements
        CreateEscalationStatusUseCase,
        UpdateEscalationStatusUseCase,
        GetEscalationStatusUseCase,
        DeleteEscalationStatusUseCase {

    private final EscalationStatusRepositoryPort repository;

    public EscalationStatusApplicationService(EscalationStatusRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public EscalationStatusResponse execute(String name) {
        EscalationStatus entity = EscalationStatus.create(EscalationStatusName.of(name));
        EscalationStatus saved = repository.save(entity);
        return EscalationStatusResponse.fromDomain(saved);
    }

    @Override
    public EscalationStatusResponse execute(UUID id, String name, String status) {
        EscalationStatusId entityId = EscalationStatusId.of(id);
        EscalationStatus entity = repository.findById(entityId)
                .orElseThrow(() -> new EscalationStatusNotFoundException(entityId));

        entity.update(EscalationStatusName.of(name), EscalationStatusStatus.of(status));
        EscalationStatus updated = repository.save(entity);
        return EscalationStatusResponse.fromDomain(updated);
    }

    @Override
    public EscalationStatusResponse getById(UUID id) {
        EscalationStatusId entityId = EscalationStatusId.of(id);
        return repository.findById(entityId)
                .map(EscalationStatusResponse::fromDomain)
                .orElseThrow(() -> new EscalationStatusNotFoundException(entityId));
    }

    @Override
    public List<EscalationStatusResponse> getAll() {
        return repository.findAll().stream()
                .map(EscalationStatusResponse::fromDomain)
                .toList();
    }

    @Override
    public void execute(UUID id) {
        EscalationStatusId entityId = EscalationStatusId.of(id);
        if (!repository.existsById(entityId)) {
            throw new EscalationStatusNotFoundException(entityId);
        }
        repository.deleteById(entityId);
    }
}
