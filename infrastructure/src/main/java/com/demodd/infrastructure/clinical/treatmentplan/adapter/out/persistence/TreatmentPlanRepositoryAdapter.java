package com.demodd.infrastructure.clinical.treatmentplan.adapter.out.persistence;

import com.demodd.domain.clinical.treatmentplan.model.aggregate.TreatmentPlan;
import com.demodd.domain.clinical.treatmentplan.model.valueobject.TreatmentPlanId;
import com.demodd.domain.clinical.treatmentplan.model.valueobject.TreatmentPlanName;
import com.demodd.domain.clinical.treatmentplan.model.valueobject.TreatmentPlanStatus;
import com.demodd.domain.clinical.treatmentplan.port.repository.TreatmentPlanRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TreatmentPlanRepositoryAdapter implements TreatmentPlanRepositoryPort {

    private final TreatmentPlanSpringDataJpaRepository repository;

    public TreatmentPlanRepositoryAdapter(TreatmentPlanSpringDataJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public TreatmentPlan save(TreatmentPlan entity) {
        TreatmentPlanJpaEntity jpaEntity = new TreatmentPlanJpaEntity(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
        TreatmentPlanJpaEntity saved = repository.save(jpaEntity);
        return toDomain(saved);
    }

    @Override
    public Optional<TreatmentPlan> findById(TreatmentPlanId id) {
        return repository.findById(id.value()).map(this::toDomain);
    }

    @Override
    public List<TreatmentPlan> findAll() {
        return repository.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    public void deleteById(TreatmentPlanId id) {
        repository.deleteById(id.value());
    }

    @Override
    public boolean existsById(TreatmentPlanId id) {
        return repository.existsById(id.value());
    }

    private TreatmentPlan toDomain(TreatmentPlanJpaEntity jpa) {
        String entityName = jpa.getName() != null ? jpa.getName() : "Sin Nombre";
        return new TreatmentPlan(
                TreatmentPlanId.of(jpa.getId()),
                TreatmentPlanName.of(entityName),
                TreatmentPlanStatus.of(jpa.getStatus()),
                jpa.getCreatedAt(),
                jpa.getUpdatedAt()
        );
    }
}
