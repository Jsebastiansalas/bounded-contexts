package com.demodd.infrastructure.clinical.medicationroute.adapter.out.persistence;

import com.demodd.domain.clinical.medicationroute.model.aggregate.MedicationRoute;
import com.demodd.domain.clinical.medicationroute.model.valueobject.MedicationRouteId;
import com.demodd.domain.clinical.medicationroute.model.valueobject.MedicationRouteName;
import com.demodd.domain.clinical.medicationroute.model.valueobject.MedicationRouteStatus;
import com.demodd.domain.clinical.medicationroute.port.repository.MedicationRouteRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MedicationRouteRepositoryAdapter implements MedicationRouteRepositoryPort {

    private final MedicationRouteSpringDataJpaRepository repository;

    public MedicationRouteRepositoryAdapter(MedicationRouteSpringDataJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public MedicationRoute save(MedicationRoute entity) {
        MedicationRouteJpaEntity jpaEntity = new MedicationRouteJpaEntity(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
        MedicationRouteJpaEntity saved = repository.save(jpaEntity);
        return toDomain(saved);
    }

    @Override
    public Optional<MedicationRoute> findById(MedicationRouteId id) {
        return repository.findById(id.value()).map(this::toDomain);
    }

    @Override
    public List<MedicationRoute> findAll() {
        return repository.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    public void deleteById(MedicationRouteId id) {
        repository.deleteById(id.value());
    }

    @Override
    public boolean existsById(MedicationRouteId id) {
        return repository.existsById(id.value());
    }

    private MedicationRoute toDomain(MedicationRouteJpaEntity jpa) {
        String entityName = jpa.getName() != null ? jpa.getName() : "Sin Nombre";
        return new MedicationRoute(
                MedicationRouteId.of(jpa.getId()),
                MedicationRouteName.of(entityName),
                MedicationRouteStatus.of(jpa.getStatus()),
                jpa.getCreatedAt(),
                jpa.getUpdatedAt()
        );
    }
}
