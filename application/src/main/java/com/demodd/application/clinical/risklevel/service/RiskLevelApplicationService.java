package com.demodd.application.clinical.risklevel.service;

import com.demodd.application.clinical.risklevel.dto.RiskLevelResponse;
import com.demodd.application.clinical.risklevel.port.in.CreateRiskLevelUseCase;
import com.demodd.application.clinical.risklevel.port.in.DeleteRiskLevelUseCase;
import com.demodd.application.clinical.risklevel.port.in.GetRiskLevelUseCase;
import com.demodd.application.clinical.risklevel.port.in.UpdateRiskLevelUseCase;
import com.demodd.domain.clinical.risklevel.exception.RiskLevelNotFoundException;
import com.demodd.domain.clinical.risklevel.model.aggregate.RiskLevel;
import com.demodd.domain.clinical.risklevel.model.valueobject.RiskLevelId;
import com.demodd.domain.clinical.risklevel.model.valueobject.RiskLevelName;
import com.demodd.domain.clinical.risklevel.model.valueobject.RiskLevelStatus;
import com.demodd.domain.clinical.risklevel.port.repository.RiskLevelRepositoryPort;

import java.util.List;
import java.util.UUID;

public class RiskLevelApplicationService implements
        CreateRiskLevelUseCase,
        UpdateRiskLevelUseCase,
        GetRiskLevelUseCase,
        DeleteRiskLevelUseCase {

    private final RiskLevelRepositoryPort repository;

    public RiskLevelApplicationService(RiskLevelRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public RiskLevelResponse execute(String name) {
        RiskLevel entity = RiskLevel.create(RiskLevelName.of(name));
        RiskLevel saved = repository.save(entity);
        return RiskLevelResponse.fromDomain(saved);
    }

    @Override
    public RiskLevelResponse execute(UUID id, String name, String status) {
        RiskLevelId entityId = RiskLevelId.of(id);
        RiskLevel entity = repository.findById(entityId)
                .orElseThrow(() -> new RiskLevelNotFoundException(entityId));

        entity.update(RiskLevelName.of(name), RiskLevelStatus.of(status));
        RiskLevel updated = repository.save(entity);
        return RiskLevelResponse.fromDomain(updated);
    }

    @Override
    public RiskLevelResponse getById(UUID id) {
        RiskLevelId entityId = RiskLevelId.of(id);
        return repository.findById(entityId)
                .map(RiskLevelResponse::fromDomain)
                .orElseThrow(() -> new RiskLevelNotFoundException(entityId));
    }

    @Override
    public List<RiskLevelResponse> getAll() {
        return repository.findAll().stream()
                .map(RiskLevelResponse::fromDomain)
                .toList();
    }

    @Override
    public void execute(UUID id) {
        RiskLevelId entityId = RiskLevelId.of(id);
        if (!repository.existsById(entityId)) {
            throw new RiskLevelNotFoundException(entityId);
        }
        repository.deleteById(entityId);
    }
}
