package com.demodd.infrastructure.chat.chatconversation.adapter.out.persistence;

import com.demodd.domain.chat.chatconversation.model.aggregate.ChatConversation;
import com.demodd.domain.chat.chatconversation.model.valueobject.ChatConversationId;
import com.demodd.domain.chat.chatconversation.model.valueobject.ChatConversationName;
import com.demodd.domain.chat.chatconversation.model.valueobject.ChatConversationStatus;
import com.demodd.domain.chat.chatconversation.port.repository.ChatConversationRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ChatConversationRepositoryAdapter implements ChatConversationRepositoryPort {

    private final ChatConversationSpringDataJpaRepository repository;

    public ChatConversationRepositoryAdapter(ChatConversationSpringDataJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public ChatConversation save(ChatConversation entity) {
        ChatConversationJpaEntity jpaEntity = new ChatConversationJpaEntity(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
        ChatConversationJpaEntity saved = repository.save(jpaEntity);
        return toDomain(saved);
    }

    @Override
    public Optional<ChatConversation> findById(ChatConversationId id) {
        return repository.findById(id.value()).map(this::toDomain);
    }

    @Override
    public List<ChatConversation> findAll() {
        return repository.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    public void deleteById(ChatConversationId id) {
        repository.deleteById(id.value());
    }

    @Override
    public boolean existsById(ChatConversationId id) {
        return repository.existsById(id.value());
    }

    private ChatConversation toDomain(ChatConversationJpaEntity jpa) {
        String entityName = jpa.getName() != null ? jpa.getName() : "Sin Nombre";
        return new ChatConversation(
                ChatConversationId.of(jpa.getId()),
                ChatConversationName.of(entityName),
                ChatConversationStatus.of(jpa.getStatus()),
                jpa.getCreatedAt(),
                jpa.getUpdatedAt()
        );
    }
}
