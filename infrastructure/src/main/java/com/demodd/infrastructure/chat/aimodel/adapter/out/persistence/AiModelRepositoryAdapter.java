package com.demodd.infrastructure.chat.aimodel.adapter.out.persistence;

import com.demodd.domain.chat.aimodel.model.aggregate.AiModel;
import com.demodd.domain.chat.aimodel.model.valueobject.AiModelId;
import com.demodd.domain.chat.aimodel.model.valueobject.AiModelName;
import com.demodd.domain.chat.aimodel.model.valueobject.AiModelStatus;
import com.demodd.domain.chat.aimodel.port.repository.AiModelRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AiModelRepositoryAdapter implements AiModelRepositoryPort {

    private final AiModelSpringDataJpaRepository repository;

    public AiModelRepositoryAdapter(AiModelSpringDataJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public AiModel save(AiModel entity) {
        AiModelJpaEntity jpaEntity = new AiModelJpaEntity(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
        AiModelJpaEntity saved = repository.save(jpaEntity);
        return toDomain(saved);
    }

    @Override
    public Optional<AiModel> findById(AiModelId id) {
        return repository.findById(id.value()).map(this::toDomain);
    }

    @Override
    public List<AiModel> findAll() {
        return repository.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    public void deleteById(AiModelId id) {
        repository.deleteById(id.value());
    }

    @Override
    public boolean existsById(AiModelId id) {
        return repository.existsById(id.value());
    }

    private AiModel toDomain(AiModelJpaEntity jpa) {
        String entityName = jpa.getName() != null ? jpa.getName() : "Sin Nombre";
        return new AiModel(
                AiModelId.of(jpa.getId()),
                AiModelName.of(entityName),
                AiModelStatus.of(jpa.getStatus()),
                jpa.getCreatedAt(),
                jpa.getUpdatedAt()
        );
    }
}
