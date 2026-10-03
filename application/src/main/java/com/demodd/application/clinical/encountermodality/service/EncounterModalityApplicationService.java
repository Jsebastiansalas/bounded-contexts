package com.demodd.application.clinical.encountermodality.service;

import com.demodd.application.clinical.encountermodality.dto.EncounterModalityResponse;
import com.demodd.application.clinical.encountermodality.port.in.CreateEncounterModalityUseCase;
import com.demodd.application.clinical.encountermodality.port.in.DeleteEncounterModalityUseCase;
import com.demodd.application.clinical.encountermodality.port.in.GetEncounterModalityUseCase;
import com.demodd.application.clinical.encountermodality.port.in.UpdateEncounterModalityUseCase;
import com.demodd.domain.clinical.encountermodality.exception.EncounterModalityNotFoundException;
import com.demodd.domain.clinical.encountermodality.model.aggregate.EncounterModality;
import com.demodd.domain.clinical.encountermodality.model.valueobject.EncounterModalityId;
import com.demodd.domain.clinical.encountermodality.model.valueobject.EncounterModalityName;
import com.demodd.domain.clinical.encountermodality.model.valueobject.EncounterModalityStatus;
import com.demodd.domain.clinical.encountermodality.port.repository.EncounterModalityRepositoryPort;

import java.util.List;
import java.util.UUID;

public class EncounterModalityApplicationService implements
        CreateEncounterModalityUseCase,
        UpdateEncounterModalityUseCase,
        GetEncounterModalityUseCase,
        DeleteEncounterModalityUseCase {

    private final EncounterModalityRepositoryPort repository;

    public EncounterModalityApplicationService(EncounterModalityRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public EncounterModalityResponse execute(String name) {
        EncounterModality entity = EncounterModality.create(EncounterModalityName.of(name));
        EncounterModality saved = repository.save(entity);
        return EncounterModalityResponse.fromDomain(saved);
    }

    @Override
    public EncounterModalityResponse execute(UUID id, String name, String status) {
        EncounterModalityId entityId = EncounterModalityId.of(id);
        EncounterModality entity = repository.findById(entityId)
                .orElseThrow(() -> new EncounterModalityNotFoundException(entityId));

        entity.update(EncounterModalityName.of(name), EncounterModalityStatus.of(status));
        EncounterModality updated = repository.save(entity);
        return EncounterModalityResponse.fromDomain(updated);
    }

    @Override
    public EncounterModalityResponse getById(UUID id) {
        EncounterModalityId entityId = EncounterModalityId.of(id);
        return repository.findById(entityId)
                .map(EncounterModalityResponse::fromDomain)
                .orElseThrow(() -> new EncounterModalityNotFoundException(entityId));
    }

    @Override
    public List<EncounterModalityResponse> getAll() {
        return repository.findAll().stream()
                .map(EncounterModalityResponse::fromDomain)
                .toList();
    }

    @Override
    public void execute(UUID id) {
        EncounterModalityId entityId = EncounterModalityId.of(id);
        if (!repository.existsById(entityId)) {
            throw new EncounterModalityNotFoundException(entityId);
        }
        repository.deleteById(entityId);
    }
}
