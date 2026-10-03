package com.demodd.infrastructure.chat.providermodelai.adapter.out.persistence;

import com.demodd.domain.chat.providermodelai.model.aggregate.ProviderModelAi;
import com.demodd.domain.chat.providermodelai.model.valueobject.ProviderModelAiId;
import com.demodd.domain.chat.providermodelai.model.valueobject.ProviderModelAiName;
import com.demodd.domain.chat.providermodelai.model.valueobject.ProviderModelAiStatus;
import com.demodd.domain.chat.providermodelai.port.repository.ProviderModelAiRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProviderModelAiRepositoryAdapter implements ProviderModelAiRepositoryPort {

    private final ProviderModelAiSpringDataJpaRepository repository;

    public ProviderModelAiRepositoryAdapter(ProviderModelAiSpringDataJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProviderModelAi save(ProviderModelAi entity) {
        ProviderModelAiJpaEntity jpaEntity = new ProviderModelAiJpaEntity(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
        ProviderModelAiJpaEntity saved = repository.save(jpaEntity);
        return toDomain(saved);
    }

    @Override
    public Optional<ProviderModelAi> findById(ProviderModelAiId id) {
        return repository.findById(id.value()).map(this::toDomain);
    }

    @Override
    public List<ProviderModelAi> findAll() {
        return repository.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    public void deleteById(ProviderModelAiId id) {
        repository.deleteById(id.value());
    }

    @Override
    public boolean existsById(ProviderModelAiId id) {
        return repository.existsById(id.value());
    }

    private ProviderModelAi toDomain(ProviderModelAiJpaEntity jpa) {
        String entityName = jpa.getName() != null ? jpa.getName() : "Sin Nombre";
        return new ProviderModelAi(
                ProviderModelAiId.of(jpa.getId()),
                ProviderModelAiName.of(entityName),
                ProviderModelAiStatus.of(jpa.getStatus()),
                jpa.getCreatedAt(),
                jpa.getUpdatedAt()
        );
    }
}
