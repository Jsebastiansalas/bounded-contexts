package com.demodd.infrastructure.patient.professional.adapter.out.persistence;

import com.demodd.domain.patient.professional.model.aggregate.Professional;
import com.demodd.domain.patient.professional.model.valueobject.ProfessionalId;
import com.demodd.domain.patient.professional.model.valueobject.ProfessionalName;
import com.demodd.domain.patient.professional.model.valueobject.ProfessionalStatus;
import com.demodd.domain.patient.professional.port.repository.ProfessionalRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProfessionalRepositoryAdapter implements ProfessionalRepositoryPort {

    private final ProfessionalSpringDataJpaRepository repository;

    public ProfessionalRepositoryAdapter(ProfessionalSpringDataJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Professional save(Professional entity) {
        ProfessionalJpaEntity jpaEntity = new ProfessionalJpaEntity(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
        ProfessionalJpaEntity saved = repository.save(jpaEntity);
        return toDomain(saved);
    }

    @Override
    public Optional<Professional> findById(ProfessionalId id) {
        return repository.findById(id.value()).map(this::toDomain);
    }

    @Override
    public List<Professional> findAll() {
        return repository.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    public void deleteById(ProfessionalId id) {
        repository.deleteById(id.value());
    }

    @Override
    public boolean existsById(ProfessionalId id) {
        return repository.existsById(id.value());
    }

    private Professional toDomain(ProfessionalJpaEntity jpa) {
        String entityName = jpa.getName() != null ? jpa.getName() : "Sin Nombre";
        return new Professional(
                ProfessionalId.of(jpa.getId()),
                ProfessionalName.of(entityName),
                ProfessionalStatus.of(jpa.getStatus()),
                jpa.getCreatedAt(),
                jpa.getUpdatedAt()
        );
    }
}
