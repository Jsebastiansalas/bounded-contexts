package com.demodd.infrastructure.clinical.treatmentgoalstatus.adapter.out.persistence;

import com.demodd.domain.clinical.treatmentgoalstatus.model.aggregate.TreatmentGoalStatus;
import com.demodd.domain.clinical.treatmentgoalstatus.model.valueobject.TreatmentGoalStatusId;
import com.demodd.domain.clinical.treatmentgoalstatus.model.valueobject.TreatmentGoalStatusName;
import com.demodd.domain.clinical.treatmentgoalstatus.model.valueobject.TreatmentGoalStatusStatus;
import com.demodd.domain.clinical.treatmentgoalstatus.port.repository.TreatmentGoalStatusRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TreatmentGoalStatusRepositoryAdapter implements TreatmentGoalStatusRepositoryPort {

    private final TreatmentGoalStatusSpringDataJpaRepository repository;

    public TreatmentGoalStatusRepositoryAdapter(TreatmentGoalStatusSpringDataJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public TreatmentGoalStatus save(TreatmentGoalStatus entity) {
        TreatmentGoalStatusJpaEntity jpaEntity = new TreatmentGoalStatusJpaEntity(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
        TreatmentGoalStatusJpaEntity saved = repository.save(jpaEntity);
        return toDomain(saved);
    }

    @Override
    public Optional<TreatmentGoalStatus> findById(TreatmentGoalStatusId id) {
        return repository.findById(id.value()).map(this::toDomain);
    }

    @Override
    public List<TreatmentGoalStatus> findAll() {
        return repository.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    public void deleteById(TreatmentGoalStatusId id) {
        repository.deleteById(id.value());
    }

    @Override
    public boolean existsById(TreatmentGoalStatusId id) {
        return repository.existsById(id.value());
    }

    private TreatmentGoalStatus toDomain(TreatmentGoalStatusJpaEntity jpa) {
        String entityName = jpa.getName() != null ? jpa.getName() : "Sin Nombre";
        return new TreatmentGoalStatus(
                TreatmentGoalStatusId.of(jpa.getId()),
                TreatmentGoalStatusName.of(entityName),
                TreatmentGoalStatusStatus.of(jpa.getStatus()),
                jpa.getCreatedAt(),
                jpa.getUpdatedAt()
        );
    }
}
