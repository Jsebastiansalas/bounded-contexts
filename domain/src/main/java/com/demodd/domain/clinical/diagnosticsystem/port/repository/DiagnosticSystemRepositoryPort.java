package com.demodd.domain.clinical.diagnosticsystem.port.repository;

import com.demodd.domain.clinical.diagnosticsystem.model.aggregate.DiagnosticSystem;
import com.demodd.domain.clinical.diagnosticsystem.model.valueobject.DiagnosticSystemId;

import java.util.List;
import java.util.Optional;

public interface DiagnosticSystemRepositoryPort {

    DiagnosticSystem save(DiagnosticSystem entity);

    Optional<DiagnosticSystem> findById(DiagnosticSystemId id);

    List<DiagnosticSystem> findAll();

    void deleteById(DiagnosticSystemId id);

    boolean existsById(DiagnosticSystemId id);
}
