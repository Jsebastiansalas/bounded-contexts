package com.demodd.infrastructure.geography.stateregion.adapter.out.persistence;

import com.demodd.domain.geography.stateregion.model.aggregate.StateRegion;
import com.demodd.domain.geography.stateregion.model.valueobject.StateRegionId;
import com.demodd.domain.geography.stateregion.model.valueobject.StateRegionName;
import com.demodd.domain.geography.stateregion.model.valueobject.StateRegionStatus;
import com.demodd.domain.geography.stateregion.port.repository.StateRegionRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class StateRegionRepositoryAdapter implements StateRegionRepositoryPort {

    private final StateRegionSpringDataJpaRepository repository;

    public StateRegionRepositoryAdapter(StateRegionSpringDataJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public StateRegion save(StateRegion entity) {
        StateRegionJpaEntity jpaEntity = new StateRegionJpaEntity(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
        StateRegionJpaEntity saved = repository.save(jpaEntity);
        return toDomain(saved);
    }

    @Override
    public Optional<StateRegion> findById(StateRegionId id) {
        return repository.findById(id.value()).map(this::toDomain);
    }

    @Override
    public List<StateRegion> findAll() {
        return repository.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    public void deleteById(StateRegionId id) {
        repository.deleteById(id.value());
    }

    @Override
    public boolean existsById(StateRegionId id) {
        return repository.existsById(id.value());
    }

    private StateRegion toDomain(StateRegionJpaEntity jpa) {
        String entityName = jpa.getName() != null ? jpa.getName() : "Sin Nombre";
        return new StateRegion(
                StateRegionId.of(jpa.getId()),
                StateRegionName.of(entityName),
                StateRegionStatus.of(jpa.getStatus()),
                jpa.getCreatedAt(),
                jpa.getUpdatedAt()
        );
    }
}
