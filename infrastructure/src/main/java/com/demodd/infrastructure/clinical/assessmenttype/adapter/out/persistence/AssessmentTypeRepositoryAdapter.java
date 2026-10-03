package com.demodd.infrastructure.clinical.assessmenttype.adapter.out.persistence;

import com.demodd.domain.clinical.assessmenttype.model.aggregate.AssessmentType;
import com.demodd.domain.clinical.assessmenttype.model.valueobject.AssessmentTypeId;
import com.demodd.domain.clinical.assessmenttype.model.valueobject.AssessmentTypeName;
import com.demodd.domain.clinical.assessmenttype.model.valueobject.AssessmentTypeStatus;
import com.demodd.domain.clinical.assessmenttype.port.repository.AssessmentTypeRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AssessmentTypeRepositoryAdapter implements AssessmentTypeRepositoryPort {

    private final AssessmentTypeSpringDataJpaRepository repository;

    public AssessmentTypeRepositoryAdapter(AssessmentTypeSpringDataJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public AssessmentType save(AssessmentType entity) {
        AssessmentTypeJpaEntity jpaEntity = new AssessmentTypeJpaEntity(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
        AssessmentTypeJpaEntity saved = repository.save(jpaEntity);
        return toDomain(saved);
    }

    @Override
    public Optional<AssessmentType> findById(AssessmentTypeId id) {
        return repository.findById(id.value()).map(this::toDomain);
    }

    @Override
    public List<AssessmentType> findAll() {
        return repository.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    public void deleteById(AssessmentTypeId id) {
        repository.deleteById(id.value());
    }

    @Override
    public boolean existsById(AssessmentTypeId id) {
        return repository.existsById(id.value());
    }

    private AssessmentType toDomain(AssessmentTypeJpaEntity jpa) {
        String entityName = jpa.getName() != null ? jpa.getName() : "Sin Nombre";
        return new AssessmentType(
                AssessmentTypeId.of(jpa.getId()),
                AssessmentTypeName.of(entityName),
                AssessmentTypeStatus.of(jpa.getStatus()),
                jpa.getCreatedAt(),
                jpa.getUpdatedAt()
        );
    }
}
