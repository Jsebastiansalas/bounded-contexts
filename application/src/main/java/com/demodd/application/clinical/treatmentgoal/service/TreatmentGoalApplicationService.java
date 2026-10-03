package com.demodd.application.clinical.treatmentgoal.service;

import com.demodd.application.clinical.treatmentgoal.dto.TreatmentGoalResponse;
import com.demodd.application.clinical.treatmentgoal.port.in.CreateTreatmentGoalUseCase;
import com.demodd.application.clinical.treatmentgoal.port.in.DeleteTreatmentGoalUseCase;
import com.demodd.application.clinical.treatmentgoal.port.in.GetTreatmentGoalUseCase;
import com.demodd.application.clinical.treatmentgoal.port.in.UpdateTreatmentGoalUseCase;
import com.demodd.domain.clinical.treatmentgoal.exception.TreatmentGoalNotFoundException;
import com.demodd.domain.clinical.treatmentgoal.model.aggregate.TreatmentGoal;
import com.demodd.domain.clinical.treatmentgoal.model.valueobject.TreatmentGoalId;
import com.demodd.domain.clinical.treatmentgoal.model.valueobject.TreatmentGoalName;
import com.demodd.domain.clinical.treatmentgoal.model.valueobject.TreatmentGoalStatus;
import com.demodd.domain.clinical.treatmentgoal.port.repository.TreatmentGoalRepositoryPort;

import java.util.List;
import java.util.UUID;

public class TreatmentGoalApplicationService implements
        CreateTreatmentGoalUseCase,
        UpdateTreatmentGoalUseCase,
        GetTreatmentGoalUseCase,
        DeleteTreatmentGoalUseCase {

    private final TreatmentGoalRepositoryPort repository;

    public TreatmentGoalApplicationService(TreatmentGoalRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public TreatmentGoalResponse execute(String name) {
        TreatmentGoal entity = TreatmentGoal.create(TreatmentGoalName.of(name));
        TreatmentGoal saved = repository.save(entity);
        return TreatmentGoalResponse.fromDomain(saved);
    }

    @Override
    public TreatmentGoalResponse execute(UUID id, String name, String status) {
        TreatmentGoalId entityId = TreatmentGoalId.of(id);
        TreatmentGoal entity = repository.findById(entityId)
                .orElseThrow(() -> new TreatmentGoalNotFoundException(entityId));

        entity.update(TreatmentGoalName.of(name), TreatmentGoalStatus.of(status));
        TreatmentGoal updated = repository.save(entity);
        return TreatmentGoalResponse.fromDomain(updated);
    }

    @Override
    public TreatmentGoalResponse getById(UUID id) {
        TreatmentGoalId entityId = TreatmentGoalId.of(id);
        return repository.findById(entityId)
                .map(TreatmentGoalResponse::fromDomain)
                .orElseThrow(() -> new TreatmentGoalNotFoundException(entityId));
    }

    @Override
    public List<TreatmentGoalResponse> getAll() {
        return repository.findAll().stream()
                .map(TreatmentGoalResponse::fromDomain)
                .toList();
    }

    @Override
    public void execute(UUID id) {
        TreatmentGoalId entityId = TreatmentGoalId.of(id);
        if (!repository.existsById(entityId)) {
            throw new TreatmentGoalNotFoundException(entityId);
        }
        repository.deleteById(entityId);
    }
}
