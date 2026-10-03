package com.demodd.infrastructure.clinical.encountertype.adapter.out.persistence;

import com.demodd.domain.clinical.encountertype.model.aggregate.EncounterType;
import com.demodd.domain.clinical.encountertype.model.valueobject.EncounterTypeId;
import com.demodd.domain.clinical.encountertype.model.valueobject.EncounterTypeName;
import com.demodd.domain.clinical.encountertype.model.valueobject.EncounterTypeStatus;
import com.demodd.domain.clinical.encountertype.port.repository.EncounterTypeRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EncounterTypeRepositoryAdapter implements EncounterTypeRepositoryPort {

    private final EncounterTypeSpringDataJpaRepository repository;

    public EncounterTypeRepositoryAdapter(EncounterTypeSpringDataJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public EncounterType save(EncounterType entity) {
        EncounterTypeJpaEntity jpaEntity = new EncounterTypeJpaEntity(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
        EncounterTypeJpaEntity saved = repository.save(jpaEntity);
        return toDomain(saved);
    }

    @Override
    public Optional<EncounterType> findById(EncounterTypeId id) {
        return repository.findById(id.value()).map(this::toDomain);
    }

    @Override
    public List<EncounterType> findAll() {
        return repository.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    public void deleteById(EncounterTypeId id) {
        repository.deleteById(id.value());
    }

    @Override
    public boolean existsById(EncounterTypeId id) {
        return repository.existsById(id.value());
    }

    private EncounterType toDomain(EncounterTypeJpaEntity jpa) {
        String entityName = jpa.getName() != null ? jpa.getName() : "Sin Nombre";
        return new EncounterType(
                EncounterTypeId.of(jpa.getId()),
                EncounterTypeName.of(entityName),
                EncounterTypeStatus.of(jpa.getStatus()),
                jpa.getCreatedAt(),
                jpa.getUpdatedAt()
        );
    }
}
