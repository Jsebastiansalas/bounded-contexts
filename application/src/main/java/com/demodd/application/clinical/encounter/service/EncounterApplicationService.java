package com.demodd.application.clinical.encounter.service;

import com.demodd.application.clinical.encounter.dto.EncounterResponse;
import com.demodd.application.clinical.encounter.port.in.CreateEncounterUseCase;
import com.demodd.application.clinical.encounter.port.in.DeleteEncounterUseCase;
import com.demodd.application.clinical.encounter.port.in.GetEncounterUseCase;
import com.demodd.application.clinical.encounter.port.in.UpdateEncounterUseCase;
import com.demodd.domain.clinical.encounter.exception.EncounterNotFoundException;
import com.demodd.domain.clinical.encounter.model.aggregate.Encounter;
import com.demodd.domain.clinical.encounter.model.valueobject.EncounterId;
import com.demodd.domain.clinical.encounter.model.valueobject.EncounterName;
import com.demodd.domain.clinical.encounter.model.valueobject.EncounterStatus;
import com.demodd.domain.clinical.encounter.port.repository.EncounterRepositoryPort;

import java.util.List;
import java.util.UUID;

public class EncounterApplicationService implements
        CreateEncounterUseCase,
        UpdateEncounterUseCase,
        GetEncounterUseCase,
        DeleteEncounterUseCase {

    private final EncounterRepositoryPort repository;

    public EncounterApplicationService(EncounterRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public EncounterResponse execute(String name) {
        Encounter entity = Encounter.create(EncounterName.of(name));
        Encounter saved = repository.save(entity);
        return EncounterResponse.fromDomain(saved);
    }

    @Override
    public EncounterResponse execute(UUID id, String name, String status) {
        EncounterId entityId = EncounterId.of(id);
        Encounter entity = repository.findById(entityId)
                .orElseThrow(() -> new EncounterNotFoundException(entityId));

        entity.update(EncounterName.of(name), EncounterStatus.of(status));
        Encounter updated = repository.save(entity);
        return EncounterResponse.fromDomain(updated);
    }

    @Override
    public EncounterResponse getById(UUID id) {
        EncounterId entityId = EncounterId.of(id);
        return repository.findById(entityId)
                .map(EncounterResponse::fromDomain)
                .orElseThrow(() -> new EncounterNotFoundException(entityId));
    }

    @Override
    public List<EncounterResponse> getAll() {
        return repository.findAll().stream()
                .map(EncounterResponse::fromDomain)
                .toList();
    }

    @Override
    public void execute(UUID id) {
        EncounterId entityId = EncounterId.of(id);
        if (!repository.existsById(entityId)) {
            throw new EncounterNotFoundException(entityId);
        }
        repository.deleteById(entityId);
    }
}
