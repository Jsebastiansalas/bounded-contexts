package com.demodd.infrastructure.chat.escalationstatus.adapter.out.persistence;

import com.demodd.domain.chat.escalationstatus.model.aggregate.EscalationStatus;
import com.demodd.domain.chat.escalationstatus.model.valueobject.EscalationStatusId;
import com.demodd.domain.chat.escalationstatus.model.valueobject.EscalationStatusName;
import com.demodd.domain.chat.escalationstatus.model.valueobject.EscalationStatusStatus;
import com.demodd.domain.chat.escalationstatus.port.repository.EscalationStatusRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EscalationStatusRepositoryAdapter implements EscalationStatusRepositoryPort {

    private final EscalationStatusSpringDataJpaRepository repository;

    public EscalationStatusRepositoryAdapter(EscalationStatusSpringDataJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public EscalationStatus save(EscalationStatus entity) {
        EscalationStatusJpaEntity jpaEntity = new EscalationStatusJpaEntity(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
        EscalationStatusJpaEntity saved = repository.save(jpaEntity);
        return toDomain(saved);
    }

    @Override
    public Optional<EscalationStatus> findById(EscalationStatusId id) {
        return repository.findById(id.value()).map(this::toDomain);
    }

    @Override
    public List<EscalationStatus> findAll() {
        return repository.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    public void deleteById(EscalationStatusId id) {
        repository.deleteById(id.value());
    }

    @Override
    public boolean existsById(EscalationStatusId id) {
        return repository.existsById(id.value());
    }

    private EscalationStatus toDomain(EscalationStatusJpaEntity jpa) {
        String entityName = jpa.getName() != null ? jpa.getName() : "Sin Nombre";
        return new EscalationStatus(
                EscalationStatusId.of(jpa.getId()),
                EscalationStatusName.of(entityName),
                EscalationStatusStatus.of(jpa.getStatus()),
                jpa.getCreatedAt(),
                jpa.getUpdatedAt()
        );
    }
}
