package com.demodd.infrastructure.clinical.encounter.adapter.out.persistence;

import com.demodd.domain.clinical.encounter.model.aggregate.Encounter;
import com.demodd.domain.clinical.encounter.model.valueobject.EncounterId;
import com.demodd.domain.clinical.encounter.model.valueobject.EncounterName;
import com.demodd.domain.clinical.encounter.model.valueobject.EncounterStatus;
import com.demodd.domain.clinical.encounter.port.repository.EncounterRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EncounterRepositoryAdapter implements EncounterRepositoryPort {

    private final EncounterSpringDataJpaRepository repository;

    public EncounterRepositoryAdapter(EncounterSpringDataJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Encounter save(Encounter entity) {
        EncounterJpaEntity jpaEntity = new EncounterJpaEntity(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
        EncounterJpaEntity saved = repository.save(jpaEntity);
        return toDomain(saved);
    }

    @Override
    public Optional<Encounter> findById(EncounterId id) {
        return repository.findById(id.value()).map(this::toDomain);
    }

    @Override
    public List<Encounter> findAll() {
        return repository.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    public void deleteById(EncounterId id) {
        repository.deleteById(id.value());
    }

    @Override
    public boolean existsById(EncounterId id) {
        return repository.existsById(id.value());
    }

    private Encounter toDomain(EncounterJpaEntity jpa) {
        String entityName = jpa.getName() != null ? jpa.getName() : "Sin Nombre";
        return new Encounter(
                EncounterId.of(jpa.getId()),
                EncounterName.of(entityName),
                EncounterStatus.of(jpa.getStatus()),
                jpa.getCreatedAt(),
                jpa.getUpdatedAt()
        );
    }
}
