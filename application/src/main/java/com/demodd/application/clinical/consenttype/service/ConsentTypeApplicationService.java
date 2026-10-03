package com.demodd.application.clinical.consenttype.service;

import com.demodd.application.clinical.consenttype.dto.ConsentTypeResponse;
import com.demodd.application.clinical.consenttype.port.in.CreateConsentTypeUseCase;
import com.demodd.application.clinical.consenttype.port.in.DeleteConsentTypeUseCase;
import com.demodd.application.clinical.consenttype.port.in.GetConsentTypeUseCase;
import com.demodd.application.clinical.consenttype.port.in.UpdateConsentTypeUseCase;
import com.demodd.domain.clinical.consenttype.exception.ConsentTypeNotFoundException;
import com.demodd.domain.clinical.consenttype.model.aggregate.ConsentType;
import com.demodd.domain.clinical.consenttype.model.valueobject.ConsentTypeId;
import com.demodd.domain.clinical.consenttype.model.valueobject.ConsentTypeName;
import com.demodd.domain.clinical.consenttype.model.valueobject.ConsentTypeStatus;
import com.demodd.domain.clinical.consenttype.port.repository.ConsentTypeRepositoryPort;

import java.util.List;
import java.util.UUID;

public class ConsentTypeApplicationService implements
        CreateConsentTypeUseCase,
        UpdateConsentTypeUseCase,
        GetConsentTypeUseCase,
        DeleteConsentTypeUseCase {

    private final ConsentTypeRepositoryPort repository;

    public ConsentTypeApplicationService(ConsentTypeRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public ConsentTypeResponse execute(String name) {
        ConsentType entity = ConsentType.create(ConsentTypeName.of(name));
        ConsentType saved = repository.save(entity);
        return ConsentTypeResponse.fromDomain(saved);
    }

    @Override
    public ConsentTypeResponse execute(UUID id, String name, String status) {
        ConsentTypeId entityId = ConsentTypeId.of(id);
        ConsentType entity = repository.findById(entityId)
                .orElseThrow(() -> new ConsentTypeNotFoundException(entityId));

        entity.update(ConsentTypeName.of(name), ConsentTypeStatus.of(status));
        ConsentType updated = repository.save(entity);
        return ConsentTypeResponse.fromDomain(updated);
    }

    @Override
    public ConsentTypeResponse getById(UUID id) {
        ConsentTypeId entityId = ConsentTypeId.of(id);
        return repository.findById(entityId)
                .map(ConsentTypeResponse::fromDomain)
                .orElseThrow(() -> new ConsentTypeNotFoundException(entityId));
    }

    @Override
    public List<ConsentTypeResponse> getAll() {
        return repository.findAll().stream()
                .map(ConsentTypeResponse::fromDomain)
                .toList();
    }

    @Override
    public void execute(UUID id) {
        ConsentTypeId entityId = ConsentTypeId.of(id);
        if (!repository.existsById(entityId)) {
            throw new ConsentTypeNotFoundException(entityId);
        }
        repository.deleteById(entityId);
    }
}
