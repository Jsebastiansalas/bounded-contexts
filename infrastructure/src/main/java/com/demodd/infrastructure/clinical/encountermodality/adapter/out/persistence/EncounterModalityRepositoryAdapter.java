package com.demodd.infrastructure.clinical.encountermodality.adapter.out.persistence;

import com.demodd.domain.clinical.encountermodality.model.aggregate.EncounterModality;
import com.demodd.domain.clinical.encountermodality.model.valueobject.EncounterModalityId;
import com.demodd.domain.clinical.encountermodality.model.valueobject.EncounterModalityName;
import com.demodd.domain.clinical.encountermodality.model.valueobject.EncounterModalityStatus;
import com.demodd.domain.clinical.encountermodality.port.repository.EncounterModalityRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EncounterModalityRepositoryAdapter implements EncounterModalityRepositoryPort {

    private final EncounterModalitySpringDataJpaRepository repository;

    public EncounterModalityRepositoryAdapter(EncounterModalitySpringDataJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public EncounterModality save(EncounterModality entity) {
        EncounterModalityJpaEntity jpaEntity = new EncounterModalityJpaEntity(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
        EncounterModalityJpaEntity saved = repository.save(jpaEntity);
        return toDomain(saved);
    }

    @Override
    public Optional<EncounterModality> findById(EncounterModalityId id) {
        return repository.findById(id.value()).map(this::toDomain);
    }

    @Override
    public List<EncounterModality> findAll() {
        return repository.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    public void deleteById(EncounterModalityId id) {
        repository.deleteById(id.value());
    }

    @Override
    public boolean existsById(EncounterModalityId id) {
        return repository.existsById(id.value());
    }

    private EncounterModality toDomain(EncounterModalityJpaEntity jpa) {
        String entityName = jpa.getName() != null ? jpa.getName() : "Sin Nombre";
        return new EncounterModality(
                EncounterModalityId.of(jpa.getId()),
                EncounterModalityName.of(entityName),
                EncounterModalityStatus.of(jpa.getStatus()),
                jpa.getCreatedAt(),
                jpa.getUpdatedAt()
        );
    }
}
