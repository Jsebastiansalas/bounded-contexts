package com.demodd.infrastructure.clinical.diagnosticsystem.adapter.out.persistence;

import com.demodd.domain.clinical.diagnosticsystem.model.aggregate.DiagnosticSystem;
import com.demodd.domain.clinical.diagnosticsystem.model.valueobject.DiagnosticSystemId;
import com.demodd.domain.clinical.diagnosticsystem.model.valueobject.DiagnosticSystemName;
import com.demodd.domain.clinical.diagnosticsystem.model.valueobject.DiagnosticSystemStatus;
import com.demodd.domain.clinical.diagnosticsystem.port.repository.DiagnosticSystemRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DiagnosticSystemRepositoryAdapter implements DiagnosticSystemRepositoryPort {

    private final DiagnosticSystemSpringDataJpaRepository repository;

    public DiagnosticSystemRepositoryAdapter(DiagnosticSystemSpringDataJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public DiagnosticSystem save(DiagnosticSystem entity) {
        DiagnosticSystemJpaEntity jpaEntity = new DiagnosticSystemJpaEntity(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
        DiagnosticSystemJpaEntity saved = repository.save(jpaEntity);
        return toDomain(saved);
    }

    @Override
    public Optional<DiagnosticSystem> findById(DiagnosticSystemId id) {
        return repository.findById(id.value()).map(this::toDomain);
    }

    @Override
    public List<DiagnosticSystem> findAll() {
        return repository.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    public void deleteById(DiagnosticSystemId id) {
        repository.deleteById(id.value());
    }

    @Override
    public boolean existsById(DiagnosticSystemId id) {
        return repository.existsById(id.value());
    }

    private DiagnosticSystem toDomain(DiagnosticSystemJpaEntity jpa) {
        String entityName = jpa.getName() != null ? jpa.getName() : "Sin Nombre";
        return new DiagnosticSystem(
                DiagnosticSystemId.of(jpa.getId()),
                DiagnosticSystemName.of(entityName),
                DiagnosticSystemStatus.of(jpa.getStatus()),
                jpa.getCreatedAt(),
                jpa.getUpdatedAt()
        );
    }
}
