package com.demodd.application.clinical.treatmentplan.service;

import com.demodd.application.clinical.treatmentplan.dto.TreatmentPlanResponse;
import com.demodd.application.clinical.treatmentplan.port.in.CreateTreatmentPlanUseCase;
import com.demodd.application.clinical.treatmentplan.port.in.DeleteTreatmentPlanUseCase;
import com.demodd.application.clinical.treatmentplan.port.in.GetTreatmentPlanUseCase;
import com.demodd.application.clinical.treatmentplan.port.in.UpdateTreatmentPlanUseCase;
import com.demodd.domain.clinical.treatmentplan.exception.TreatmentPlanNotFoundException;
import com.demodd.domain.clinical.treatmentplan.model.aggregate.TreatmentPlan;
import com.demodd.domain.clinical.treatmentplan.model.valueobject.TreatmentPlanId;
import com.demodd.domain.clinical.treatmentplan.model.valueobject.TreatmentPlanName;
import com.demodd.domain.clinical.treatmentplan.model.valueobject.TreatmentPlanStatus;
import com.demodd.domain.clinical.treatmentplan.port.repository.TreatmentPlanRepositoryPort;

import java.util.List;
import java.util.UUID;

public class TreatmentPlanApplicationService implements
        CreateTreatmentPlanUseCase,
        UpdateTreatmentPlanUseCase,
        GetTreatmentPlanUseCase,
        DeleteTreatmentPlanUseCase {

    private final TreatmentPlanRepositoryPort repository;

    public TreatmentPlanApplicationService(TreatmentPlanRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public TreatmentPlanResponse execute(String name) {
        TreatmentPlan entity = TreatmentPlan.create(TreatmentPlanName.of(name));
        TreatmentPlan saved = repository.save(entity);
        return TreatmentPlanResponse.fromDomain(saved);
    }

    @Override
    public TreatmentPlanResponse execute(UUID id, String name, String status) {
        TreatmentPlanId entityId = TreatmentPlanId.of(id);
        TreatmentPlan entity = repository.findById(entityId)
                .orElseThrow(() -> new TreatmentPlanNotFoundException(entityId));

        entity.update(TreatmentPlanName.of(name), TreatmentPlanStatus.of(status));
        TreatmentPlan updated = repository.save(entity);
        return TreatmentPlanResponse.fromDomain(updated);
    }

    @Override
    public TreatmentPlanResponse getById(UUID id) {
        TreatmentPlanId entityId = TreatmentPlanId.of(id);
        return repository.findById(entityId)
                .map(TreatmentPlanResponse::fromDomain)
                .orElseThrow(() -> new TreatmentPlanNotFoundException(entityId));
    }

    @Override
    public List<TreatmentPlanResponse> getAll() {
        return repository.findAll().stream()
                .map(TreatmentPlanResponse::fromDomain)
                .toList();
    }

    @Override
    public void execute(UUID id) {
        TreatmentPlanId entityId = TreatmentPlanId.of(id);
        if (!repository.existsById(entityId)) {
            throw new TreatmentPlanNotFoundException(entityId);
        }
        repository.deleteById(entityId);
    }
}
