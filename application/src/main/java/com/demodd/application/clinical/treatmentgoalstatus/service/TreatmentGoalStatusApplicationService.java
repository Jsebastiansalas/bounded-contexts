package com.demodd.application.clinical.treatmentgoalstatus.service;

import com.demodd.application.clinical.treatmentgoalstatus.dto.TreatmentGoalStatusResponse;
import com.demodd.application.clinical.treatmentgoalstatus.port.in.CreateTreatmentGoalStatusUseCase;
import com.demodd.application.clinical.treatmentgoalstatus.port.in.DeleteTreatmentGoalStatusUseCase;
import com.demodd.application.clinical.treatmentgoalstatus.port.in.GetTreatmentGoalStatusUseCase;
import com.demodd.application.clinical.treatmentgoalstatus.port.in.UpdateTreatmentGoalStatusUseCase;
import com.demodd.domain.clinical.treatmentgoalstatus.exception.TreatmentGoalStatusNotFoundException;
import com.demodd.domain.clinical.treatmentgoalstatus.model.aggregate.TreatmentGoalStatus;
import com.demodd.domain.clinical.treatmentgoalstatus.model.valueobject.TreatmentGoalStatusId;
import com.demodd.domain.clinical.treatmentgoalstatus.model.valueobject.TreatmentGoalStatusName;
import com.demodd.domain.clinical.treatmentgoalstatus.model.valueobject.TreatmentGoalStatusStatus;
import com.demodd.domain.clinical.treatmentgoalstatus.port.repository.TreatmentGoalStatusRepositoryPort;

import java.util.List;
import java.util.UUID;

public class TreatmentGoalStatusApplicationService implements
        CreateTreatmentGoalStatusUseCase,
        UpdateTreatmentGoalStatusUseCase,
        GetTreatmentGoalStatusUseCase,
        DeleteTreatmentGoalStatusUseCase {

    private final TreatmentGoalStatusRepositoryPort repository;

    public TreatmentGoalStatusApplicationService(TreatmentGoalStatusRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public TreatmentGoalStatusResponse execute(String name) {
        TreatmentGoalStatus entity = TreatmentGoalStatus.create(TreatmentGoalStatusName.of(name));
        TreatmentGoalStatus saved = repository.save(entity);
        return TreatmentGoalStatusResponse.fromDomain(saved);
    }

    @Override
    public TreatmentGoalStatusResponse execute(UUID id, String name, String status) {
        TreatmentGoalStatusId entityId = TreatmentGoalStatusId.of(id);
        TreatmentGoalStatus entity = repository.findById(entityId)
                .orElseThrow(() -> new TreatmentGoalStatusNotFoundException(entityId));

        entity.update(TreatmentGoalStatusName.of(name), TreatmentGoalStatusStatus.of(status));
        TreatmentGoalStatus updated = repository.save(entity);
        return TreatmentGoalStatusResponse.fromDomain(updated);
    }

    @Override
    public TreatmentGoalStatusResponse getById(UUID id) {
        TreatmentGoalStatusId entityId = TreatmentGoalStatusId.of(id);
        return repository.findById(entityId)
                .map(TreatmentGoalStatusResponse::fromDomain)
                .orElseThrow(() -> new TreatmentGoalStatusNotFoundException(entityId));
    }

    @Override
    public List<TreatmentGoalStatusResponse> getAll() {
        return repository.findAll().stream()
                .map(TreatmentGoalStatusResponse::fromDomain)
                .toList();
    }

    @Override
    public void execute(UUID id) {
        TreatmentGoalStatusId entityId = TreatmentGoalStatusId.of(id);
        if (!repository.existsById(entityId)) {
            throw new TreatmentGoalStatusNotFoundException(entityId);
        }
        repository.deleteById(entityId);
    }
}
