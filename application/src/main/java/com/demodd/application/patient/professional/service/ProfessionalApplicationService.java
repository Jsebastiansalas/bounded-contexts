package com.demodd.application.patient.professional.service;

import com.demodd.application.patient.professional.dto.ProfessionalResponse;
import com.demodd.application.patient.professional.port.in.CreateProfessionalUseCase;
import com.demodd.application.patient.professional.port.in.DeleteProfessionalUseCase;
import com.demodd.application.patient.professional.port.in.GetProfessionalUseCase;
import com.demodd.application.patient.professional.port.in.UpdateProfessionalUseCase;
import com.demodd.domain.patient.professional.exception.ProfessionalNotFoundException;
import com.demodd.domain.patient.professional.model.aggregate.Professional;
import com.demodd.domain.patient.professional.model.valueobject.ProfessionalId;
import com.demodd.domain.patient.professional.model.valueobject.ProfessionalName;
import com.demodd.domain.patient.professional.model.valueobject.ProfessionalStatus;
import com.demodd.domain.patient.professional.port.repository.ProfessionalRepositoryPort;

import java.util.List;
import java.util.UUID;

public class ProfessionalApplicationService implements
        CreateProfessionalUseCase,
        UpdateProfessionalUseCase,
        GetProfessionalUseCase,
        DeleteProfessionalUseCase {

    private final ProfessionalRepositoryPort repository;

    public ProfessionalApplicationService(ProfessionalRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public ProfessionalResponse execute(String name) {
        Professional entity = Professional.create(ProfessionalName.of(name));
        Professional saved = repository.save(entity);
        return ProfessionalResponse.fromDomain(saved);
    }

    @Override
    public ProfessionalResponse execute(UUID id, String name, String status) {
        ProfessionalId entityId = ProfessionalId.of(id);
        Professional entity = repository.findById(entityId)
                .orElseThrow(() -> new ProfessionalNotFoundException(entityId));

        entity.update(ProfessionalName.of(name), ProfessionalStatus.of(status));
        Professional updated = repository.save(entity);
        return ProfessionalResponse.fromDomain(updated);
    }

    @Override
    public ProfessionalResponse getById(UUID id) {
        ProfessionalId entityId = ProfessionalId.of(id);
        return repository.findById(entityId)
                .map(ProfessionalResponse::fromDomain)
                .orElseThrow(() -> new ProfessionalNotFoundException(entityId));
    }

    @Override
    public List<ProfessionalResponse> getAll() {
        return repository.findAll().stream()
                .map(ProfessionalResponse::fromDomain)
                .toList();
    }

    @Override
    public void execute(UUID id) {
        ProfessionalId entityId = ProfessionalId.of(id);
        if (!repository.existsById(entityId)) {
            throw new ProfessionalNotFoundException(entityId);
        }
        repository.deleteById(entityId);
    }
}
