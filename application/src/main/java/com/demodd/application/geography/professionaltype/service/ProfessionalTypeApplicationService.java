package com.demodd.application.geography.professionaltype.service;

import com.demodd.application.geography.professionaltype.dto.ProfessionalTypeResponse;
import com.demodd.application.geography.professionaltype.port.in.CreateProfessionalTypeUseCase;
import com.demodd.application.geography.professionaltype.port.in.DeleteProfessionalTypeUseCase;
import com.demodd.application.geography.professionaltype.port.in.GetProfessionalTypeUseCase;
import com.demodd.application.geography.professionaltype.port.in.UpdateProfessionalTypeUseCase;
import com.demodd.domain.geography.professionaltype.exception.ProfessionalTypeNotFoundException;
import com.demodd.domain.geography.professionaltype.model.aggregate.ProfessionalType;
import com.demodd.domain.geography.professionaltype.model.valueobject.ProfessionalTypeId;
import com.demodd.domain.geography.professionaltype.model.valueobject.ProfessionalTypeName;
import com.demodd.domain.geography.professionaltype.model.valueobject.ProfessionalTypeStatus;
import com.demodd.domain.geography.professionaltype.port.repository.ProfessionalTypeRepositoryPort;

import java.util.List;
import java.util.UUID;

public class ProfessionalTypeApplicationService implements
        CreateProfessionalTypeUseCase,
        UpdateProfessionalTypeUseCase,
        GetProfessionalTypeUseCase,
        DeleteProfessionalTypeUseCase {

    private final ProfessionalTypeRepositoryPort repository;

    public ProfessionalTypeApplicationService(ProfessionalTypeRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public ProfessionalTypeResponse execute(String name) {
        ProfessionalType entity = ProfessionalType.create(ProfessionalTypeName.of(name));
        ProfessionalType saved = repository.save(entity);
        return ProfessionalTypeResponse.fromDomain(saved);
    }

    @Override
    public ProfessionalTypeResponse execute(UUID id, String name, String status) {
        ProfessionalTypeId entityId = ProfessionalTypeId.of(id);
        ProfessionalType entity = repository.findById(entityId)
                .orElseThrow(() -> new ProfessionalTypeNotFoundException(entityId));

        entity.update(ProfessionalTypeName.of(name), ProfessionalTypeStatus.of(status));
        ProfessionalType updated = repository.save(entity);
        return ProfessionalTypeResponse.fromDomain(updated);
    }

    @Override
    public ProfessionalTypeResponse getById(UUID id) {
        ProfessionalTypeId entityId = ProfessionalTypeId.of(id);
        return repository.findById(entityId)
                .map(ProfessionalTypeResponse::fromDomain)
                .orElseThrow(() -> new ProfessionalTypeNotFoundException(entityId));
    }

    @Override
    public List<ProfessionalTypeResponse> getAll() {
        return repository.findAll().stream()
                .map(ProfessionalTypeResponse::fromDomain)
                .toList();
    }

    @Override
    public void execute(UUID id) {
        ProfessionalTypeId entityId = ProfessionalTypeId.of(id);
        if (!repository.existsById(entityId)) {
            throw new ProfessionalTypeNotFoundException(entityId);
        }
        repository.deleteById(entityId);
    }
}
