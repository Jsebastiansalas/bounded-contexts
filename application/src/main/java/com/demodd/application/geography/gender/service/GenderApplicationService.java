package com.demodd.application.geography.gender.service;

import com.demodd.application.geography.gender.dto.GenderResponse;
import com.demodd.application.geography.gender.port.in.CreateGenderUseCase;
import com.demodd.application.geography.gender.port.in.DeleteGenderUseCase;
import com.demodd.application.geography.gender.port.in.GetGenderUseCase;
import com.demodd.application.geography.gender.port.in.UpdateGenderUseCase;
import com.demodd.domain.geography.gender.exception.GenderNotFoundException;
import com.demodd.domain.geography.gender.model.aggregate.Gender;
import com.demodd.domain.geography.gender.model.valueobject.GenderId;
import com.demodd.domain.geography.gender.model.valueobject.GenderName;
import com.demodd.domain.geography.gender.model.valueobject.GenderStatus;
import com.demodd.domain.geography.gender.port.repository.GenderRepositoryPort;

import java.util.List;
import java.util.UUID;

public class GenderApplicationService implements
        CreateGenderUseCase,
        UpdateGenderUseCase,
        GetGenderUseCase,
        DeleteGenderUseCase {

    private final GenderRepositoryPort repository;

    public GenderApplicationService(GenderRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public GenderResponse execute(String name) {
        Gender entity = Gender.create(GenderName.of(name));
        Gender saved = repository.save(entity);
        return GenderResponse.fromDomain(saved);
    }

    @Override
    public GenderResponse execute(UUID id, String name, String status) {
        GenderId entityId = GenderId.of(id);
        Gender entity = repository.findById(entityId)
                .orElseThrow(() -> new GenderNotFoundException(entityId));

        entity.update(GenderName.of(name), GenderStatus.of(status));
        Gender updated = repository.save(entity);
        return GenderResponse.fromDomain(updated);
    }

    @Override
    public GenderResponse getById(UUID id) {
        GenderId entityId = GenderId.of(id);
        return repository.findById(entityId)
                .map(GenderResponse::fromDomain)
                .orElseThrow(() -> new GenderNotFoundException(entityId));
    }

    @Override
    public List<GenderResponse> getAll() {
        return repository.findAll().stream()
                .map(GenderResponse::fromDomain)
                .toList();
    }

    @Override
    public void execute(UUID id) {
        GenderId entityId = GenderId.of(id);
        if (!repository.existsById(entityId)) {
            throw new GenderNotFoundException(entityId);
        }
        repository.deleteById(entityId);
    }
}
