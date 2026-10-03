package com.demodd.application.clinical.encounterstatus.service;

import com.demodd.application.clinical.encounterstatus.dto.EncounterStatusResponse;
import com.demodd.application.clinical.encounterstatus.port.in.CreateEncounterStatusUseCase;
import com.demodd.application.clinical.encounterstatus.port.in.DeleteEncounterStatusUseCase;
import com.demodd.application.clinical.encounterstatus.port.in.GetEncounterStatusUseCase;
import com.demodd.application.clinical.encounterstatus.port.in.UpdateEncounterStatusUseCase;
import com.demodd.domain.clinical.encounterstatus.exception.EncounterStatusNotFoundException;
import com.demodd.domain.clinical.encounterstatus.model.aggregate.EncounterStatus;
import com.demodd.domain.clinical.encounterstatus.model.valueobject.EncounterStatusId;
import com.demodd.domain.clinical.encounterstatus.model.valueobject.EncounterStatusName;
import com.demodd.domain.clinical.encounterstatus.model.valueobject.EncounterStatusStatus;
import com.demodd.domain.clinical.encounterstatus.port.repository.EncounterStatusRepositoryPort;

import java.util.List;
import java.util.UUID;

public class EncounterStatusApplicationService implements
        CreateEncounterStatusUseCase,
        UpdateEncounterStatusUseCase,
        GetEncounterStatusUseCase,
        DeleteEncounterStatusUseCase {

    private final EncounterStatusRepositoryPort repository;

    public EncounterStatusApplicationService(EncounterStatusRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public EncounterStatusResponse execute(String name) {
        EncounterStatus entity = EncounterStatus.create(EncounterStatusName.of(name));
        EncounterStatus saved = repository.save(entity);
        return EncounterStatusResponse.fromDomain(saved);
    }

    @Override
    public EncounterStatusResponse execute(UUID id, String name, String status) {
        EncounterStatusId entityId = EncounterStatusId.of(id);
        EncounterStatus entity = repository.findById(entityId)
                .orElseThrow(() -> new EncounterStatusNotFoundException(entityId));

        entity.update(EncounterStatusName.of(name), EncounterStatusStatus.of(status));
        EncounterStatus updated = repository.save(entity);
        return EncounterStatusResponse.fromDomain(updated);
    }

    @Override
    public EncounterStatusResponse getById(UUID id) {
        EncounterStatusId entityId = EncounterStatusId.of(id);
        return repository.findById(entityId)
                .map(EncounterStatusResponse::fromDomain)
                .orElseThrow(() -> new EncounterStatusNotFoundException(entityId));
    }

    @Override
    public List<EncounterStatusResponse> getAll() {
        return repository.findAll().stream()
                .map(EncounterStatusResponse::fromDomain)
                .toList();
    }

    @Override
    public void execute(UUID id) {
        EncounterStatusId entityId = EncounterStatusId.of(id);
        if (!repository.existsById(entityId)) {
            throw new EncounterStatusNotFoundException(entityId);
        }
        repository.deleteById(entityId);
    }
}
