package com.demodd.infrastructure.chat.chatmessage.adapter.out.persistence;

import com.demodd.domain.chat.chatmessage.model.aggregate.ChatMessage;
import com.demodd.domain.chat.chatmessage.model.valueobject.ChatMessageId;
import com.demodd.domain.chat.chatmessage.model.valueobject.ChatMessageName;
import com.demodd.domain.chat.chatmessage.model.valueobject.ChatMessageStatus;
import com.demodd.domain.chat.chatmessage.port.repository.ChatMessageRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ChatMessageRepositoryAdapter implements ChatMessageRepositoryPort {

    private final ChatMessageSpringDataJpaRepository repository;

    public ChatMessageRepositoryAdapter(ChatMessageSpringDataJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public ChatMessage save(ChatMessage entity) {
        ChatMessageJpaEntity jpaEntity = new ChatMessageJpaEntity(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
        ChatMessageJpaEntity saved = repository.save(jpaEntity);
        return toDomain(saved);
    }

    @Override
    public Optional<ChatMessage> findById(ChatMessageId id) {
        return repository.findById(id.value()).map(this::toDomain);
    }

    @Override
    public List<ChatMessage> findAll() {
        return repository.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    public void deleteById(ChatMessageId id) {
        repository.deleteById(id.value());
    }

    @Override
    public boolean existsById(ChatMessageId id) {
        return repository.existsById(id.value());
    }

    private ChatMessage toDomain(ChatMessageJpaEntity jpa) {
        String entityName = jpa.getName() != null ? jpa.getName() : "Sin Nombre";
        return new ChatMessage(
                ChatMessageId.of(jpa.getId()),
                ChatMessageName.of(entityName),
                ChatMessageStatus.of(jpa.getStatus()),
                jpa.getCreatedAt(),
                jpa.getUpdatedAt()
        );
    }
}
