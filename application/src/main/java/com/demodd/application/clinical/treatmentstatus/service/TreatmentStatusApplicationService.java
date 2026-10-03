package com.demodd.application.clinical.treatmentstatus.service;

import com.demodd.application.clinical.treatmentstatus.dto.TreatmentStatusResponse;
import com.demodd.application.clinical.treatmentstatus.port.in.CreateTreatmentStatusUseCase;
import com.demodd.application.clinical.treatmentstatus.port.in.DeleteTreatmentStatusUseCase;
import com.demodd.application.clinical.treatmentstatus.port.in.GetTreatmentStatusUseCase;
import com.demodd.application.clinical.treatmentstatus.port.in.UpdateTreatmentStatusUseCase;
import com.demodd.domain.clinical.treatmentstatus.exception.TreatmentStatusNotFoundException;
import com.demodd.domain.clinical.treatmentstatus.model.aggregate.TreatmentStatus;
import com.demodd.domain.clinical.treatmentstatus.model.valueobject.TreatmentStatusId;
import com.demodd.domain.clinical.treatmentstatus.model.valueobject.TreatmentStatusName;
import com.demodd.domain.clinical.treatmentstatus.model.valueobject.TreatmentStatusStatus;
import com.demodd.domain.clinical.treatmentstatus.port.repository.TreatmentStatusRepositoryPort;

import java.util.List;
import java.util.UUID;

public class TreatmentStatusApplicationService implements
        CreateTreatmentStatusUseCase,
        UpdateTreatmentStatusUseCase,
        GetTreatmentStatusUseCase,
        DeleteTreatmentStatusUseCase {

    private final TreatmentStatusRepositoryPort repository;

    public TreatmentStatusApplicationService(TreatmentStatusRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public TreatmentStatusResponse execute(String name) {
        TreatmentStatus entity = TreatmentStatus.create(TreatmentStatusName.of(name));
        TreatmentStatus saved = repository.save(entity);
        return TreatmentStatusResponse.fromDomain(saved);
    }

    @Override
    public TreatmentStatusResponse execute(UUID id, String name, String status) {
        TreatmentStatusId entityId = TreatmentStatusId.of(id);
        TreatmentStatus entity = repository.findById(entityId)
                .orElseThrow(() -> new TreatmentStatusNotFoundException(entityId));

        entity.update(TreatmentStatusName.of(name), TreatmentStatusStatus.of(status));
        TreatmentStatus updated = repository.save(entity);
        return TreatmentStatusResponse.fromDomain(updated);
    }

    @Override
    public TreatmentStatusResponse getById(UUID id) {
        TreatmentStatusId entityId = TreatmentStatusId.of(id);
        return repository.findById(entityId)
                .map(TreatmentStatusResponse::fromDomain)
                .orElseThrow(() -> new TreatmentStatusNotFoundException(entityId));
    }

    @Override
    public List<TreatmentStatusResponse> getAll() {
        return repository.findAll().stream()
                .map(TreatmentStatusResponse::fromDomain)
                .toList();
    }

    @Override
    public void execute(UUID id) {
        TreatmentStatusId entityId = TreatmentStatusId.of(id);
        if (!repository.existsById(entityId)) {
            throw new TreatmentStatusNotFoundException(entityId);
        }
        repository.deleteById(entityId);
    }
}
