package com.demodd.application.clinical.clinicalrecord.service;

import com.demodd.application.clinical.clinicalrecord.dto.ClinicalRecordResponse;
import com.demodd.application.clinical.clinicalrecord.port.in.CreateClinicalRecordUseCase;
import com.demodd.application.clinical.clinicalrecord.port.in.DeleteClinicalRecordUseCase;
import com.demodd.application.clinical.clinicalrecord.port.in.GetClinicalRecordUseCase;
import com.demodd.application.clinical.clinicalrecord.port.in.UpdateClinicalRecordUseCase;
import com.demodd.domain.clinical.clinicalrecord.exception.ClinicalRecordNotFoundException;
import com.demodd.domain.clinical.clinicalrecord.model.aggregate.ClinicalRecord;
import com.demodd.domain.clinical.clinicalrecord.model.valueobject.ClinicalRecordId;
import com.demodd.domain.clinical.clinicalrecord.model.valueobject.ClinicalRecordName;
import com.demodd.domain.clinical.clinicalrecord.model.valueobject.ClinicalRecordStatus;
import com.demodd.domain.clinical.clinicalrecord.port.repository.ClinicalRecordRepositoryPort;

import java.util.List;
import java.util.UUID;

public class ClinicalRecordApplicationService implements
        CreateClinicalRecordUseCase,
        UpdateClinicalRecordUseCase,
        GetClinicalRecordUseCase,
        DeleteClinicalRecordUseCase {

    private final ClinicalRecordRepositoryPort repository;

    public ClinicalRecordApplicationService(ClinicalRecordRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public ClinicalRecordResponse execute(String name) {
        ClinicalRecord entity = ClinicalRecord.create(ClinicalRecordName.of(name));
        ClinicalRecord saved = repository.save(entity);
        return ClinicalRecordResponse.fromDomain(saved);
    }

    @Override
    public ClinicalRecordResponse execute(UUID id, String name, String status) {
        ClinicalRecordId entityId = ClinicalRecordId.of(id);
        ClinicalRecord entity = repository.findById(entityId)
                .orElseThrow(() -> new ClinicalRecordNotFoundException(entityId));

        entity.update(ClinicalRecordName.of(name), ClinicalRecordStatus.of(status));
        ClinicalRecord updated = repository.save(entity);
        return ClinicalRecordResponse.fromDomain(updated);
    }

    @Override
    public ClinicalRecordResponse getById(UUID id) {
        ClinicalRecordId entityId = ClinicalRecordId.of(id);
        return repository.findById(entityId)
                .map(ClinicalRecordResponse::fromDomain)
                .orElseThrow(() -> new ClinicalRecordNotFoundException(entityId));
    }

    @Override
    public List<ClinicalRecordResponse> getAll() {
        return repository.findAll().stream()
                .map(ClinicalRecordResponse::fromDomain)
                .toList();
    }

    @Override
    public void execute(UUID id) {
        ClinicalRecordId entityId = ClinicalRecordId.of(id);
        if (!repository.existsById(entityId)) {
            throw new ClinicalRecordNotFoundException(entityId);
        }
        repository.deleteById(entityId);
    }
}
