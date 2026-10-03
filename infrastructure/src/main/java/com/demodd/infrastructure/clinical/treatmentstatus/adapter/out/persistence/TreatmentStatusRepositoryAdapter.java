package com.demodd.infrastructure.clinical.treatmentstatus.adapter.out.persistence;

import com.demodd.domain.clinical.treatmentstatus.model.aggregate.TreatmentStatus;
import com.demodd.domain.clinical.treatmentstatus.model.valueobject.TreatmentStatusId;
import com.demodd.domain.clinical.treatmentstatus.model.valueobject.TreatmentStatusName;
import com.demodd.domain.clinical.treatmentstatus.model.valueobject.TreatmentStatusStatus;
import com.demodd.domain.clinical.treatmentstatus.port.repository.TreatmentStatusRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TreatmentStatusRepositoryAdapter implements TreatmentStatusRepositoryPort {

    private final TreatmentStatusSpringDataJpaRepository repository;

    public TreatmentStatusRepositoryAdapter(TreatmentStatusSpringDataJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public TreatmentStatus save(TreatmentStatus entity) {
        TreatmentStatusJpaEntity jpaEntity = new TreatmentStatusJpaEntity(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
        TreatmentStatusJpaEntity saved = repository.save(jpaEntity);
        return toDomain(saved);
    }

    @Override
    public Optional<TreatmentStatus> findById(TreatmentStatusId id) {
        return repository.findById(id.value()).map(this::toDomain);
    }

    @Override
    public List<TreatmentStatus> findAll() {
        return repository.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    public void deleteById(TreatmentStatusId id) {
        repository.deleteById(id.value());
    }

    @Override
    public boolean existsById(TreatmentStatusId id) {
        return repository.existsById(id.value());
    }

    private TreatmentStatus toDomain(TreatmentStatusJpaEntity jpa) {
        String entityName = jpa.getName() != null ? jpa.getName() : "Sin Nombre";
        return new TreatmentStatus(
                TreatmentStatusId.of(jpa.getId()),
                TreatmentStatusName.of(entityName),
                TreatmentStatusStatus.of(jpa.getStatus()),
                jpa.getCreatedAt(),
                jpa.getUpdatedAt()
        );
    }
}
