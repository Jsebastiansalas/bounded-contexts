package com.demodd.infrastructure.clinical.risklevel.adapter.out.persistence;

import com.demodd.domain.clinical.risklevel.model.aggregate.RiskLevel;
import com.demodd.domain.clinical.risklevel.model.valueobject.RiskLevelId;
import com.demodd.domain.clinical.risklevel.model.valueobject.RiskLevelName;
import com.demodd.domain.clinical.risklevel.model.valueobject.RiskLevelStatus;
import com.demodd.domain.clinical.risklevel.port.repository.RiskLevelRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class RiskLevelRepositoryAdapter implements RiskLevelRepositoryPort {

    private final RiskLevelSpringDataJpaRepository repository;

    public RiskLevelRepositoryAdapter(RiskLevelSpringDataJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public RiskLevel save(RiskLevel entity) {
        RiskLevelJpaEntity jpaEntity = new RiskLevelJpaEntity(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
        RiskLevelJpaEntity saved = repository.save(jpaEntity);
        return toDomain(saved);
    }

    @Override
    public Optional<RiskLevel> findById(RiskLevelId id) {
        return repository.findById(id.value()).map(this::toDomain);
    }

    @Override
    public List<RiskLevel> findAll() {
        return repository.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    public void deleteById(RiskLevelId id) {
        repository.deleteById(id.value());
    }

    @Override
    public boolean existsById(RiskLevelId id) {
        return repository.existsById(id.value());
    }

    private RiskLevel toDomain(RiskLevelJpaEntity jpa) {
        String entityName = jpa.getName() != null ? jpa.getName() : "Sin Nombre";
        return new RiskLevel(
                RiskLevelId.of(jpa.getId()),
                RiskLevelName.of(entityName),
                RiskLevelStatus.of(jpa.getStatus()),
                jpa.getCreatedAt(),
                jpa.getUpdatedAt()
        );
    }
}
