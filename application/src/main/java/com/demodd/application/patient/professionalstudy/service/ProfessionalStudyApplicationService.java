package com.demodd.application.patient.professionalstudy.service;

import com.demodd.application.patient.professionalstudy.dto.ProfessionalStudyResponse;
import com.demodd.application.patient.professionalstudy.port.in.CreateProfessionalStudyUseCase;
import com.demodd.application.patient.professionalstudy.port.in.DeleteProfessionalStudyUseCase;
import com.demodd.application.patient.professionalstudy.port.in.GetProfessionalStudyUseCase;
import com.demodd.application.patient.professionalstudy.port.in.UpdateProfessionalStudyUseCase;
import com.demodd.domain.patient.professionalstudy.exception.ProfessionalStudyNotFoundException;
import com.demodd.domain.patient.professionalstudy.model.aggregate.ProfessionalStudy;
import com.demodd.domain.patient.professionalstudy.model.valueobject.ProfessionalStudyId;
import com.demodd.domain.patient.professionalstudy.model.valueobject.ProfessionalStudyName;
import com.demodd.domain.patient.professionalstudy.model.valueobject.ProfessionalStudyStatus;
import com.demodd.domain.patient.professionalstudy.port.repository.ProfessionalStudyRepositoryPort;

import java.util.List;
import java.util.UUID;

public class ProfessionalStudyApplicationService implements
        CreateProfessionalStudyUseCase,
        UpdateProfessionalStudyUseCase,
        GetProfessionalStudyUseCase,
        DeleteProfessionalStudyUseCase {

    private final ProfessionalStudyRepositoryPort repository;

    public ProfessionalStudyApplicationService(ProfessionalStudyRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public ProfessionalStudyResponse execute(String name) {
        ProfessionalStudy entity = ProfessionalStudy.create(ProfessionalStudyName.of(name));
        ProfessionalStudy saved = repository.save(entity);
        return ProfessionalStudyResponse.fromDomain(saved);
    }

    @Override
    public ProfessionalStudyResponse execute(UUID id, String name, String status) {
        ProfessionalStudyId entityId = ProfessionalStudyId.of(id);
        ProfessionalStudy entity = repository.findById(entityId)
                .orElseThrow(() -> new ProfessionalStudyNotFoundException(entityId));

        entity.update(ProfessionalStudyName.of(name), ProfessionalStudyStatus.of(status));
        ProfessionalStudy updated = repository.save(entity);
        return ProfessionalStudyResponse.fromDomain(updated);
    }

    @Override
    public ProfessionalStudyResponse getById(UUID id) {
        ProfessionalStudyId entityId = ProfessionalStudyId.of(id);
        return repository.findById(entityId)
                .map(ProfessionalStudyResponse::fromDomain)
                .orElseThrow(() -> new ProfessionalStudyNotFoundException(entityId));
    }

    @Override
    public List<ProfessionalStudyResponse> getAll() {
        return repository.findAll().stream()
                .map(ProfessionalStudyResponse::fromDomain)
                .toList();
    }

    @Override
    public void execute(UUID id) {
        ProfessionalStudyId entityId = ProfessionalStudyId.of(id);
        if (!repository.existsById(entityId)) {
            throw new ProfessionalStudyNotFoundException(entityId);
        }
        repository.deleteById(entityId);
    }
}
