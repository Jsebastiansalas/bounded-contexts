package com.demodd.application.clinical.encountertype.service;

import com.demodd.application.clinical.encountertype.dto.EncounterTypeResponse;
import com.demodd.application.clinical.encountertype.port.in.CreateEncounterTypeUseCase;
import com.demodd.application.clinical.encountertype.port.in.DeleteEncounterTypeUseCase;
import com.demodd.application.clinical.encountertype.port.in.GetEncounterTypeUseCase;
import com.demodd.application.clinical.encountertype.port.in.UpdateEncounterTypeUseCase;
import com.demodd.domain.clinical.encountertype.exception.EncounterTypeNotFoundException;
import com.demodd.domain.clinical.encountertype.model.aggregate.EncounterType;
import com.demodd.domain.clinical.encountertype.model.valueobject.EncounterTypeId;
import com.demodd.domain.clinical.encountertype.model.valueobject.EncounterTypeName;
import com.demodd.domain.clinical.encountertype.model.valueobject.EncounterTypeStatus;
import com.demodd.domain.clinical.encountertype.port.repository.EncounterTypeRepositoryPort;

import java.util.List;
import java.util.UUID;

public class EncounterTypeApplicationService implements
        CreateEncounterTypeUseCase,
        UpdateEncounterTypeUseCase,
        GetEncounterTypeUseCase,
        DeleteEncounterTypeUseCase {

    private final EncounterTypeRepositoryPort repository;

    public EncounterTypeApplicationService(EncounterTypeRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public EncounterTypeResponse execute(String name) {
        EncounterType entity = EncounterType.create(EncounterTypeName.of(name));
        EncounterType saved = repository.save(entity);
        return EncounterTypeResponse.fromDomain(saved);
    }

    @Override
    public EncounterTypeResponse execute(UUID id, String name, String status) {
        EncounterTypeId entityId = EncounterTypeId.of(id);
        EncounterType entity = repository.findById(entityId)
                .orElseThrow(() -> new EncounterTypeNotFoundException(entityId));

        entity.update(EncounterTypeName.of(name), EncounterTypeStatus.of(status));
        EncounterType updated = repository.save(entity);
        return EncounterTypeResponse.fromDomain(updated);
    }

    @Override
    public EncounterTypeResponse getById(UUID id) {
        EncounterTypeId entityId = EncounterTypeId.of(id);
        return repository.findById(entityId)
                .map(EncounterTypeResponse::fromDomain)
                .orElseThrow(() -> new EncounterTypeNotFoundException(entityId));
    }

    @Override
    public List<EncounterTypeResponse> getAll() {
        return repository.findAll().stream()
                .map(EncounterTypeResponse::fromDomain)
                .toList();
    }

    @Override
    public void execute(UUID id) {
        EncounterTypeId entityId = EncounterTypeId.of(id);
        if (!repository.existsById(entityId)) {
            throw new EncounterTypeNotFoundException(entityId);
        }
        repository.deleteById(entityId);
    }
}
