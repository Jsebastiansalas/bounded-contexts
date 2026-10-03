package com.demodd.infrastructure.clinical.encounterstatus.adapter.out.persistence;

import com.demodd.domain.clinical.encounterstatus.model.aggregate.EncounterStatus;
import com.demodd.domain.clinical.encounterstatus.model.valueobject.EncounterStatusId;
import com.demodd.domain.clinical.encounterstatus.model.valueobject.EncounterStatusName;
import com.demodd.domain.clinical.encounterstatus.model.valueobject.EncounterStatusStatus;
import com.demodd.domain.clinical.encounterstatus.port.repository.EncounterStatusRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EncounterStatusRepositoryAdapter implements EncounterStatusRepositoryPort {

    private final EncounterStatusSpringDataJpaRepository repository;

    public EncounterStatusRepositoryAdapter(EncounterStatusSpringDataJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public EncounterStatus save(EncounterStatus entity) {
        EncounterStatusJpaEntity jpaEntity = new EncounterStatusJpaEntity(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
        EncounterStatusJpaEntity saved = repository.save(jpaEntity);
        return toDomain(saved);
    }

    @Override
    public Optional<EncounterStatus> findById(EncounterStatusId id) {
        return repository.findById(id.value()).map(this::toDomain);
    }

    @Override
    public List<EncounterStatus> findAll() {
        return repository.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    public void deleteById(EncounterStatusId id) {
        repository.deleteById(id.value());
    }

    @Override
    public boolean existsById(EncounterStatusId id) {
        return repository.existsById(id.value());
    }

    private EncounterStatus toDomain(EncounterStatusJpaEntity jpa) {
        String entityName = jpa.getName() != null ? jpa.getName() : "Sin Nombre";
        return new EncounterStatus(
                EncounterStatusId.of(jpa.getId()),
                EncounterStatusName.of(entityName),
                EncounterStatusStatus.of(jpa.getStatus()),
                jpa.getCreatedAt(),
                jpa.getUpdatedAt()
        );
    }
}
