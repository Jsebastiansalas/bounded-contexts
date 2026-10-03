package com.demodd.application.clinical.diagnosticsystem.service;

import com.demodd.application.clinical.diagnosticsystem.dto.DiagnosticSystemResponse;
import com.demodd.application.clinical.diagnosticsystem.port.in.CreateDiagnosticSystemUseCase;
import com.demodd.application.clinical.diagnosticsystem.port.in.DeleteDiagnosticSystemUseCase;
import com.demodd.application.clinical.diagnosticsystem.port.in.GetDiagnosticSystemUseCase;
import com.demodd.application.clinical.diagnosticsystem.port.in.UpdateDiagnosticSystemUseCase;
import com.demodd.domain.clinical.diagnosticsystem.exception.DiagnosticSystemNotFoundException;
import com.demodd.domain.clinical.diagnosticsystem.model.aggregate.DiagnosticSystem;
import com.demodd.domain.clinical.diagnosticsystem.model.valueobject.DiagnosticSystemId;
import com.demodd.domain.clinical.diagnosticsystem.model.valueobject.DiagnosticSystemName;
import com.demodd.domain.clinical.diagnosticsystem.model.valueobject.DiagnosticSystemStatus;
import com.demodd.domain.clinical.diagnosticsystem.port.repository.DiagnosticSystemRepositoryPort;

import java.util.List;
import java.util.UUID;

public class DiagnosticSystemApplicationService implements
        CreateDiagnosticSystemUseCase,
        UpdateDiagnosticSystemUseCase,
        GetDiagnosticSystemUseCase,
        DeleteDiagnosticSystemUseCase {

    private final DiagnosticSystemRepositoryPort repository;

    public DiagnosticSystemApplicationService(DiagnosticSystemRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public DiagnosticSystemResponse execute(String name) {
        DiagnosticSystem entity = DiagnosticSystem.create(DiagnosticSystemName.of(name));
        DiagnosticSystem saved = repository.save(entity);
        return DiagnosticSystemResponse.fromDomain(saved);
    }

    @Override
    public DiagnosticSystemResponse execute(UUID id, String name, String status) {
        DiagnosticSystemId entityId = DiagnosticSystemId.of(id);
        DiagnosticSystem entity = repository.findById(entityId)
                .orElseThrow(() -> new DiagnosticSystemNotFoundException(entityId));

        entity.update(DiagnosticSystemName.of(name), DiagnosticSystemStatus.of(status));
        DiagnosticSystem updated = repository.save(entity);
        return DiagnosticSystemResponse.fromDomain(updated);
    }

    @Override
    public DiagnosticSystemResponse getById(UUID id) {
        DiagnosticSystemId entityId = DiagnosticSystemId.of(id);
        return repository.findById(entityId)
                .map(DiagnosticSystemResponse::fromDomain)
                .orElseThrow(() -> new DiagnosticSystemNotFoundException(entityId));
    }

    @Override
    public List<DiagnosticSystemResponse> getAll() {
        return repository.findAll().stream()
                .map(DiagnosticSystemResponse::fromDomain)
                .toList();
    }

    @Override
    public void execute(UUID id) {
        DiagnosticSystemId entityId = DiagnosticSystemId.of(id);
        if (!repository.existsById(entityId)) {
            throw new DiagnosticSystemNotFoundException(entityId);
        }
        repository.deleteById(entityId);
    }
}
