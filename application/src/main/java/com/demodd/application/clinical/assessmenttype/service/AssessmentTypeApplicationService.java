package com.demodd.application.clinical.assessmenttype.service;

import com.demodd.application.clinical.assessmenttype.dto.AssessmentTypeResponse;
import com.demodd.application.clinical.assessmenttype.port.in.CreateAssessmentTypeUseCase;
import com.demodd.application.clinical.assessmenttype.port.in.DeleteAssessmentTypeUseCase;
import com.demodd.application.clinical.assessmenttype.port.in.GetAssessmentTypeUseCase;
import com.demodd.application.clinical.assessmenttype.port.in.UpdateAssessmentTypeUseCase;
import com.demodd.domain.clinical.assessmenttype.exception.AssessmentTypeNotFoundException;
import com.demodd.domain.clinical.assessmenttype.model.aggregate.AssessmentType;
import com.demodd.domain.clinical.assessmenttype.model.valueobject.AssessmentTypeId;
import com.demodd.domain.clinical.assessmenttype.model.valueobject.AssessmentTypeName;
import com.demodd.domain.clinical.assessmenttype.model.valueobject.AssessmentTypeStatus;
import com.demodd.domain.clinical.assessmenttype.port.repository.AssessmentTypeRepositoryPort;

import java.util.List;
import java.util.UUID;

public class AssessmentTypeApplicationService implements
        CreateAssessmentTypeUseCase,
        UpdateAssessmentTypeUseCase,
        GetAssessmentTypeUseCase,
        DeleteAssessmentTypeUseCase {

    private final AssessmentTypeRepositoryPort repository;

    public AssessmentTypeApplicationService(AssessmentTypeRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public AssessmentTypeResponse execute(String name) {
        AssessmentType entity = AssessmentType.create(AssessmentTypeName.of(name));
        AssessmentType saved = repository.save(entity);
        return AssessmentTypeResponse.fromDomain(saved);
    }

    @Override
    public AssessmentTypeResponse execute(UUID id, String name, String status) {
        AssessmentTypeId entityId = AssessmentTypeId.of(id);
        AssessmentType entity = repository.findById(entityId)
                .orElseThrow(() -> new AssessmentTypeNotFoundException(entityId));

        entity.update(AssessmentTypeName.of(name), AssessmentTypeStatus.of(status));
        AssessmentType updated = repository.save(entity);
        return AssessmentTypeResponse.fromDomain(updated);
    }

    @Override
    public AssessmentTypeResponse getById(UUID id) {
        AssessmentTypeId entityId = AssessmentTypeId.of(id);
        return repository.findById(entityId)
                .map(AssessmentTypeResponse::fromDomain)
                .orElseThrow(() -> new AssessmentTypeNotFoundException(entityId));
    }

    @Override
    public List<AssessmentTypeResponse> getAll() {
        return repository.findAll().stream()
                .map(AssessmentTypeResponse::fromDomain)
                .toList();
    }

    @Override
    public void execute(UUID id) {
        AssessmentTypeId entityId = AssessmentTypeId.of(id);
        if (!repository.existsById(entityId)) {
            throw new AssessmentTypeNotFoundException(entityId);
        }
        repository.deleteById(entityId);
    }
}
