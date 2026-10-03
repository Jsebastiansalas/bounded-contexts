package com.demodd.infrastructure.clinical.riskassessment.adapter.out.persistence;

import com.demodd.domain.clinical.riskassessment.model.aggregate.RiskAssessment;
import com.demodd.domain.clinical.riskassessment.model.valueobject.RiskAssessmentId;
import com.demodd.domain.clinical.riskassessment.model.valueobject.RiskAssessmentName;
import com.demodd.domain.clinical.riskassessment.model.valueobject.RiskAssessmentStatus;
import com.demodd.domain.clinical.riskassessment.port.repository.RiskAssessmentRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class RiskAssessmentRepositoryAdapter implements RiskAssessmentRepositoryPort {

    private final RiskAssessmentSpringDataJpaRepository repository;

    public RiskAssessmentRepositoryAdapter(RiskAssessmentSpringDataJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public RiskAssessment save(RiskAssessment entity) {
        RiskAssessmentJpaEntity jpaEntity = new RiskAssessmentJpaEntity(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
        RiskAssessmentJpaEntity saved = repository.save(jpaEntity);
        return toDomain(saved);
    }

    @Override
    public Optional<RiskAssessment> findById(RiskAssessmentId id) {
        return repository.findById(id.value()).map(this::toDomain);
    }

    @Override
    public List<RiskAssessment> findAll() {
        return repository.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    public void deleteById(RiskAssessmentId id) {
        repository.deleteById(id.value());
    }

    @Override
    public boolean existsById(RiskAssessmentId id) {
        return repository.existsById(id.value());
    }

    private RiskAssessment toDomain(RiskAssessmentJpaEntity jpa) {
        String entityName = jpa.getName() != null ? jpa.getName() : "Sin Nombre";
        return new RiskAssessment(
                RiskAssessmentId.of(jpa.getId()),
                RiskAssessmentName.of(entityName),
                RiskAssessmentStatus.of(jpa.getStatus()),
                jpa.getCreatedAt(),
                jpa.getUpdatedAt()
        );
    }
}
