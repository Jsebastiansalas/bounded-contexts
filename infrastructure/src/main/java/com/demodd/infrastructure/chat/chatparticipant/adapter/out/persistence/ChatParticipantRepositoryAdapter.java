package com.demodd.infrastructure.chat.chatparticipant.adapter.out.persistence;

import com.demodd.domain.chat.chatparticipant.model.aggregate.ChatParticipant;
import com.demodd.domain.chat.chatparticipant.model.valueobject.ChatParticipantId;
import com.demodd.domain.chat.chatparticipant.model.valueobject.ChatParticipantName;
import com.demodd.domain.chat.chatparticipant.model.valueobject.ChatParticipantStatus;
import com.demodd.domain.chat.chatparticipant.port.repository.ChatParticipantRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ChatParticipantRepositoryAdapter implements ChatParticipantRepositoryPort {

    private final ChatParticipantSpringDataJpaRepository repository;

    public ChatParticipantRepositoryAdapter(ChatParticipantSpringDataJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public ChatParticipant save(ChatParticipant entity) {
        ChatParticipantJpaEntity jpaEntity = new ChatParticipantJpaEntity(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
        ChatParticipantJpaEntity saved = repository.save(jpaEntity);
        return toDomain(saved);
    }

    @Override
    public Optional<ChatParticipant> findById(ChatParticipantId id) {
        return repository.findById(id.value()).map(this::toDomain);
    }

    @Override
    public List<ChatParticipant> findAll() {
        return repository.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    public void deleteById(ChatParticipantId id) {
        repository.deleteById(id.value());
    }

    @Override
    public boolean existsById(ChatParticipantId id) {
        return repository.existsById(id.value());
    }

    private ChatParticipant toDomain(ChatParticipantJpaEntity jpa) {
        String entityName = jpa.getName() != null ? jpa.getName() : "Sin Nombre";
        return new ChatParticipant(
                ChatParticipantId.of(jpa.getId()),
                ChatParticipantName.of(entityName),
                ChatParticipantStatus.of(jpa.getStatus()),
                jpa.getCreatedAt(),
                jpa.getUpdatedAt()
        );
    }
}
