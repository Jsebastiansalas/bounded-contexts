package com.demodd.application.clinical.clinicalrecordstatus.service;

import com.demodd.application.clinical.clinicalrecordstatus.dto.ClinicalRecordStatusResponse;
import com.demodd.application.clinical.clinicalrecordstatus.port.in.CreateClinicalRecordStatusUseCase;
import com.demodd.application.clinical.clinicalrecordstatus.port.in.DeleteClinicalRecordStatusUseCase;
import com.demodd.application.clinical.clinicalrecordstatus.port.in.GetClinicalRecordStatusUseCase;
import com.demodd.application.clinical.clinicalrecordstatus.port.in.UpdateClinicalRecordStatusUseCase;
import com.demodd.domain.clinical.clinicalrecordstatus.exception.ClinicalRecordStatusNotFoundException;
import com.demodd.domain.clinical.clinicalrecordstatus.model.aggregate.ClinicalRecordStatus;
import com.demodd.domain.clinical.clinicalrecordstatus.model.valueobject.ClinicalRecordStatusId;
import com.demodd.domain.clinical.clinicalrecordstatus.model.valueobject.ClinicalRecordStatusName;
import com.demodd.domain.clinical.clinicalrecordstatus.model.valueobject.ClinicalRecordStatusStatus;
import com.demodd.domain.clinical.clinicalrecordstatus.port.repository.ClinicalRecordStatusRepositoryPort;

import java.util.List;
import java.util.UUID;

public class ClinicalRecordStatusApplicationService implements
        CreateClinicalRecordStatusUseCase,
        UpdateClinicalRecordStatusUseCase,
        GetClinicalRecordStatusUseCase,
        DeleteClinicalRecordStatusUseCase {

    private final ClinicalRecordStatusRepositoryPort repository;

    public ClinicalRecordStatusApplicationService(ClinicalRecordStatusRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public ClinicalRecordStatusResponse execute(String name) {
        ClinicalRecordStatus entity = ClinicalRecordStatus.create(ClinicalRecordStatusName.of(name));
        ClinicalRecordStatus saved = repository.save(entity);
        return ClinicalRecordStatusResponse.fromDomain(saved);
    }

    @Override
    public ClinicalRecordStatusResponse execute(UUID id, String name, String status) {
        ClinicalRecordStatusId entityId = ClinicalRecordStatusId.of(id);
        ClinicalRecordStatus entity = repository.findById(entityId)
                .orElseThrow(() -> new ClinicalRecordStatusNotFoundException(entityId));

        entity.update(ClinicalRecordStatusName.of(name), ClinicalRecordStatusStatus.of(status));
        ClinicalRecordStatus updated = repository.save(entity);
        return ClinicalRecordStatusResponse.fromDomain(updated);
    }

    @Override
    public ClinicalRecordStatusResponse getById(UUID id) {
        ClinicalRecordStatusId entityId = ClinicalRecordStatusId.of(id);
        return repository.findById(entityId)
                .map(ClinicalRecordStatusResponse::fromDomain)
                .orElseThrow(() -> new ClinicalRecordStatusNotFoundException(entityId));
    }

    @Override
    public List<ClinicalRecordStatusResponse> getAll() {
        return repository.findAll().stream()
                .map(ClinicalRecordStatusResponse::fromDomain)
                .toList();
    }

    @Override
    public void execute(UUID id) {
        ClinicalRecordStatusId entityId = ClinicalRecordStatusId.of(id);
        if (!repository.existsById(entityId)) {
            throw new ClinicalRecordStatusNotFoundException(entityId);
        }
        repository.deleteById(entityId);
    }
}
