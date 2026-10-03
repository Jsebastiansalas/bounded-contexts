package com.demodd.application.clinical.clinicalnote.service;

import com.demodd.application.clinical.clinicalnote.dto.ClinicalNoteResponse;
import com.demodd.application.clinical.clinicalnote.port.in.CreateClinicalNoteUseCase;
import com.demodd.application.clinical.clinicalnote.port.in.DeleteClinicalNoteUseCase;
import com.demodd.application.clinical.clinicalnote.port.in.GetClinicalNoteUseCase;
import com.demodd.application.clinical.clinicalnote.port.in.UpdateClinicalNoteUseCase;
import com.demodd.domain.clinical.clinicalnote.exception.ClinicalNoteNotFoundException;
import com.demodd.domain.clinical.clinicalnote.model.aggregate.ClinicalNote;
import com.demodd.domain.clinical.clinicalnote.model.valueobject.ClinicalNoteId;
import com.demodd.domain.clinical.clinicalnote.model.valueobject.ClinicalNoteName;
import com.demodd.domain.clinical.clinicalnote.model.valueobject.ClinicalNoteStatus;
import com.demodd.domain.clinical.clinicalnote.port.repository.ClinicalNoteRepositoryPort;

import java.util.List;
import java.util.UUID;

public class ClinicalNoteApplicationService implements
        CreateClinicalNoteUseCase,
        UpdateClinicalNoteUseCase,
        GetClinicalNoteUseCase,
        DeleteClinicalNoteUseCase {

    private final ClinicalNoteRepositoryPort repository;

    public ClinicalNoteApplicationService(ClinicalNoteRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public ClinicalNoteResponse execute(String name) {
        ClinicalNote entity = ClinicalNote.create(ClinicalNoteName.of(name));
        ClinicalNote saved = repository.save(entity);
        return ClinicalNoteResponse.fromDomain(saved);
    }

    @Override
    public ClinicalNoteResponse execute(UUID id, String name, String status) {
        ClinicalNoteId entityId = ClinicalNoteId.of(id);
        ClinicalNote entity = repository.findById(entityId)
                .orElseThrow(() -> new ClinicalNoteNotFoundException(entityId));

        entity.update(ClinicalNoteName.of(name), ClinicalNoteStatus.of(status));
        ClinicalNote updated = repository.save(entity);
        return ClinicalNoteResponse.fromDomain(updated);
    }

    @Override
    public ClinicalNoteResponse getById(UUID id) {
        ClinicalNoteId entityId = ClinicalNoteId.of(id);
        return repository.findById(entityId)
                .map(ClinicalNoteResponse::fromDomain)
                .orElseThrow(() -> new ClinicalNoteNotFoundException(entityId));
    }

    @Override
    public List<ClinicalNoteResponse> getAll() {
        return repository.findAll().stream()
                .map(ClinicalNoteResponse::fromDomain)
                .toList();
    }

    @Override
    public void execute(UUID id) {
        ClinicalNoteId entityId = ClinicalNoteId.of(id);
        if (!repository.existsById(entityId)) {
            throw new ClinicalNoteNotFoundException(entityId);
        }
        repository.deleteById(entityId);
    }
}
