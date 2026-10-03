package com.demodd.infrastructure.clinical.treatmentgoal.adapter.out.persistence;

import com.demodd.domain.clinical.treatmentgoal.model.aggregate.TreatmentGoal;
import com.demodd.domain.clinical.treatmentgoal.model.valueobject.TreatmentGoalId;
import com.demodd.domain.clinical.treatmentgoal.model.valueobject.TreatmentGoalName;
import com.demodd.domain.clinical.treatmentgoal.model.valueobject.TreatmentGoalStatus;
import com.demodd.domain.clinical.treatmentgoal.port.repository.TreatmentGoalRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TreatmentGoalRepositoryAdapter implements TreatmentGoalRepositoryPort {

    private final TreatmentGoalSpringDataJpaRepository repository;

    public TreatmentGoalRepositoryAdapter(TreatmentGoalSpringDataJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public TreatmentGoal save(TreatmentGoal entity) {
        TreatmentGoalJpaEntity jpaEntity = new TreatmentGoalJpaEntity(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
        TreatmentGoalJpaEntity saved = repository.save(jpaEntity);
        return toDomain(saved);
    }

    @Override
    public Optional<TreatmentGoal> findById(TreatmentGoalId id) {
        return repository.findById(id.value()).map(this::toDomain);
    }

    @Override
    public List<TreatmentGoal> findAll() {
        return repository.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    public void deleteById(TreatmentGoalId id) {
        repository.deleteById(id.value());
    }

    @Override
    public boolean existsById(TreatmentGoalId id) {
        return repository.existsById(id.value());
    }

    private TreatmentGoal toDomain(TreatmentGoalJpaEntity jpa) {
        String entityName = jpa.getName() != null ? jpa.getName() : "Sin Nombre";
        return new TreatmentGoal(
                TreatmentGoalId.of(jpa.getId()),
                TreatmentGoalName.of(entityName),
                TreatmentGoalStatus.of(jpa.getStatus()),
                jpa.getCreatedAt(),
                jpa.getUpdatedAt()
        );
    }
}
