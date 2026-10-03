package com.demodd.infrastructure.chat.chatairunerror.adapter.out.persistence;

import com.demodd.domain.chat.chatairunerror.model.aggregate.ChatAiRunError;
import com.demodd.domain.chat.chatairunerror.model.valueobject.ChatAiRunErrorId;
import com.demodd.domain.chat.chatairunerror.model.valueobject.ChatAiRunErrorName;
import com.demodd.domain.chat.chatairunerror.model.valueobject.ChatAiRunErrorStatus;
import com.demodd.domain.chat.chatairunerror.port.repository.ChatAiRunErrorRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ChatAiRunErrorRepositoryAdapter implements ChatAiRunErrorRepositoryPort {

    private final ChatAiRunErrorSpringDataJpaRepository repository;

    public ChatAiRunErrorRepositoryAdapter(ChatAiRunErrorSpringDataJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public ChatAiRunError save(ChatAiRunError entity) {
        ChatAiRunErrorJpaEntity jpaEntity = new ChatAiRunErrorJpaEntity(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
        ChatAiRunErrorJpaEntity saved = repository.save(jpaEntity);
        return toDomain(saved);
    }

    @Override
    public Optional<ChatAiRunError> findById(ChatAiRunErrorId id) {
        return repository.findById(id.value()).map(this::toDomain);
    }

    @Override
    public List<ChatAiRunError> findAll() {
        return repository.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    public void deleteById(ChatAiRunErrorId id) {
        repository.deleteById(id.value());
    }

    @Override
    public boolean existsById(ChatAiRunErrorId id) {
        return repository.existsById(id.value());
    }

    private ChatAiRunError toDomain(ChatAiRunErrorJpaEntity jpa) {
        String entityName = jpa.getName() != null ? jpa.getName() : "Sin Nombre";
        return new ChatAiRunError(
                ChatAiRunErrorId.of(jpa.getId()),
                ChatAiRunErrorName.of(entityName),
                ChatAiRunErrorStatus.of(jpa.getStatus()),
                jpa.getCreatedAt(),
                jpa.getUpdatedAt()
        );
    }
}
