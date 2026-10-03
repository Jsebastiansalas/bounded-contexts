package com.demodd.infrastructure.chat.airunstatus.adapter.out.persistence;

import com.demodd.domain.chat.airunstatus.model.aggregate.AiRunStatus;
import com.demodd.domain.chat.airunstatus.model.valueobject.AiRunStatusId;
import com.demodd.domain.chat.airunstatus.model.valueobject.AiRunStatusName;
import com.demodd.domain.chat.airunstatus.model.valueobject.AiRunStatusStatus;
import com.demodd.domain.chat.airunstatus.port.repository.AiRunStatusRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AiRunStatusRepositoryAdapter implements AiRunStatusRepositoryPort {

    private final AiRunStatusSpringDataJpaRepository repository;

    public AiRunStatusRepositoryAdapter(AiRunStatusSpringDataJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public AiRunStatus save(AiRunStatus entity) {
        AiRunStatusJpaEntity jpaEntity = new AiRunStatusJpaEntity(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
        AiRunStatusJpaEntity saved = repository.save(jpaEntity);
        return toDomain(saved);
    }

    @Override
    public Optional<AiRunStatus> findById(AiRunStatusId id) {
        return repository.findById(id.value()).map(this::toDomain);
    }

    @Override
    public List<AiRunStatus> findAll() {
        return repository.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    public void deleteById(AiRunStatusId id) {
        repository.deleteById(id.value());
    }

    @Override
    public boolean existsById(AiRunStatusId id) {
        return repository.existsById(id.value());
    }

    private AiRunStatus toDomain(AiRunStatusJpaEntity jpa) {
        String entityName = jpa.getName() != null ? jpa.getName() : "Sin Nombre";
        return new AiRunStatus(
                AiRunStatusId.of(jpa.getId()),
                AiRunStatusName.of(entityName),
                AiRunStatusStatus.of(jpa.getStatus()),
                jpa.getCreatedAt(),
                jpa.getUpdatedAt()
        );
    }
}
