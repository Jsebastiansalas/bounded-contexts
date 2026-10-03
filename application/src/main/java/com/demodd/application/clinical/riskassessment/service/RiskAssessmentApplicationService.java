package com.demodd.application.clinical.riskassessment.service;

import com.demodd.application.clinical.riskassessment.dto.RiskAssessmentResponse;
import com.demodd.application.clinical.riskassessment.port.in.CreateRiskAssessmentUseCase;
import com.demodd.application.clinical.riskassessment.port.in.DeleteRiskAssessmentUseCase;
import com.demodd.application.clinical.riskassessment.port.in.GetRiskAssessmentUseCase;
import com.demodd.application.clinical.riskassessment.port.in.UpdateRiskAssessmentUseCase;
import com.demodd.domain.clinical.riskassessment.exception.RiskAssessmentNotFoundException;
import com.demodd.domain.clinical.riskassessment.model.aggregate.RiskAssessment;
import com.demodd.domain.clinical.riskassessment.model.valueobject.RiskAssessmentId;
import com.demodd.domain.clinical.riskassessment.model.valueobject.RiskAssessmentName;
import com.demodd.domain.clinical.riskassessment.model.valueobject.RiskAssessmentStatus;
import com.demodd.domain.clinical.riskassessment.port.repository.RiskAssessmentRepositoryPort;

import java.util.List;
import java.util.UUID;

public class RiskAssessmentApplicationService implements
        CreateRiskAssessmentUseCase,
        UpdateRiskAssessmentUseCase,
        GetRiskAssessmentUseCase,
        DeleteRiskAssessmentUseCase {

    private final RiskAssessmentRepositoryPort repository;

    public RiskAssessmentApplicationService(RiskAssessmentRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public RiskAssessmentResponse execute(String name) {
        RiskAssessment entity = RiskAssessment.create(RiskAssessmentName.of(name));
        RiskAssessment saved = repository.save(entity);
        return RiskAssessmentResponse.fromDomain(saved);
    }

    @Override
    public RiskAssessmentResponse execute(UUID id, String name, String status) {
        RiskAssessmentId entityId = RiskAssessmentId.of(id);
        RiskAssessment entity = repository.findById(entityId)
                .orElseThrow(() -> new RiskAssessmentNotFoundException(entityId));

        entity.update(RiskAssessmentName.of(name), RiskAssessmentStatus.of(status));
        RiskAssessment updated = repository.save(entity);
        return RiskAssessmentResponse.fromDomain(updated);
    }

    @Override
    public RiskAssessmentResponse getById(UUID id) {
        RiskAssessmentId entityId = RiskAssessmentId.of(id);
        return repository.findById(entityId)
                .map(RiskAssessmentResponse::fromDomain)
                .orElseThrow(() -> new RiskAssessmentNotFoundException(entityId));
    }

    @Override
    public List<RiskAssessmentResponse> getAll() {
        return repository.findAll().stream()
                .map(RiskAssessmentResponse::fromDomain)
                .toList();
    }

    @Override
    public void execute(UUID id) {
        RiskAssessmentId entityId = RiskAssessmentId.of(id);
        if (!repository.existsById(entityId)) {
            throw new RiskAssessmentNotFoundException(entityId);
        }
        repository.deleteById(entityId);
    }
}
