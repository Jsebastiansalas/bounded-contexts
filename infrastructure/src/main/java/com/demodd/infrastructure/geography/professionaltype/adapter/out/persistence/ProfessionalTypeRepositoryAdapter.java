package com.demodd.infrastructure.geography.professionaltype.adapter.out.persistence;

import com.demodd.domain.geography.professionaltype.model.aggregate.ProfessionalType;
import com.demodd.domain.geography.professionaltype.model.valueobject.ProfessionalTypeId;
import com.demodd.domain.geography.professionaltype.model.valueobject.ProfessionalTypeName;
import com.demodd.domain.geography.professionaltype.model.valueobject.ProfessionalTypeStatus;
import com.demodd.domain.geography.professionaltype.port.repository.ProfessionalTypeRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProfessionalTypeRepositoryAdapter implements ProfessionalTypeRepositoryPort {

    private final ProfessionalTypeSpringDataJpaRepository repository;

    public ProfessionalTypeRepositoryAdapter(ProfessionalTypeSpringDataJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProfessionalType save(ProfessionalType entity) {
        ProfessionalTypeJpaEntity jpaEntity = new ProfessionalTypeJpaEntity(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
        ProfessionalTypeJpaEntity saved = repository.save(jpaEntity);
        return toDomain(saved);
    }

    @Override
    public Optional<ProfessionalType> findById(ProfessionalTypeId id) {
        return repository.findById(id.value()).map(this::toDomain);
    }

    @Override
    public List<ProfessionalType> findAll() {
        return repository.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    public void deleteById(ProfessionalTypeId id) {
        repository.deleteById(id.value());
    }

    @Override
    public boolean existsById(ProfessionalTypeId id) {
        return repository.existsById(id.value());
    }

    private ProfessionalType toDomain(ProfessionalTypeJpaEntity jpa) {
        String entityName = jpa.getName() != null ? jpa.getName() : "Sin Nombre";
        return new ProfessionalType(
                ProfessionalTypeId.of(jpa.getId()),
                ProfessionalTypeName.of(entityName),
                ProfessionalTypeStatus.of(jpa.getStatus()),
                jpa.getCreatedAt(),
                jpa.getUpdatedAt()
        );
    }
}
