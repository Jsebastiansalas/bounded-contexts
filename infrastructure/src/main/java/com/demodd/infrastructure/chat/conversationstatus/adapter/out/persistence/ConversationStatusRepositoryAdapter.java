package com.demodd.infrastructure.chat.conversationstatus.adapter.out.persistence;

import com.demodd.domain.chat.conversationstatus.model.aggregate.ConversationStatus;
import com.demodd.domain.chat.conversationstatus.model.valueobject.ConversationStatusId;
import com.demodd.domain.chat.conversationstatus.model.valueobject.ConversationStatusName;
import com.demodd.domain.chat.conversationstatus.model.valueobject.ConversationStatusStatus;
import com.demodd.domain.chat.conversationstatus.port.repository.ConversationStatusRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ConversationStatusRepositoryAdapter implements ConversationStatusRepositoryPort {

    private final ConversationStatusSpringDataJpaRepository repository;

    public ConversationStatusRepositoryAdapter(ConversationStatusSpringDataJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public ConversationStatus save(ConversationStatus entity) {
        ConversationStatusJpaEntity jpaEntity = new ConversationStatusJpaEntity(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
        ConversationStatusJpaEntity saved = repository.save(jpaEntity);
        return toDomain(saved);
    }

    @Override
    public Optional<ConversationStatus> findById(ConversationStatusId id) {
        return repository.findById(id.value()).map(this::toDomain);
    }

    @Override
    public List<ConversationStatus> findAll() {
        return repository.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    public void deleteById(ConversationStatusId id) {
        repository.deleteById(id.value());
    }

    @Override
    public boolean existsById(ConversationStatusId id) {
        return repository.existsById(id.value());
    }

    private ConversationStatus toDomain(ConversationStatusJpaEntity jpa) {
        String entityName = jpa.getName() != null ? jpa.getName() : "Sin Nombre";
        return new ConversationStatus(
                ConversationStatusId.of(jpa.getId()),
                ConversationStatusName.of(entityName),
                ConversationStatusStatus.of(jpa.getStatus()),
                jpa.getCreatedAt(),
                jpa.getUpdatedAt()
        );
    }
}
