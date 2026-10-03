package com.demodd.infrastructure.chat.chatescalation.adapter.out.persistence;

import com.demodd.domain.chat.chatescalation.model.aggregate.ChatEscalation;
import com.demodd.domain.chat.chatescalation.model.valueobject.ChatEscalationId;
import com.demodd.domain.chat.chatescalation.model.valueobject.ChatEscalationName;
import com.demodd.domain.chat.chatescalation.model.valueobject.ChatEscalationStatus;
import com.demodd.domain.chat.chatescalation.port.repository.ChatEscalationRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ChatEscalationRepositoryAdapter implements ChatEscalationRepositoryPort {

    private final ChatEscalationSpringDataJpaRepository repository;

    public ChatEscalationRepositoryAdapter(ChatEscalationSpringDataJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public ChatEscalation save(ChatEscalation entity) {
        ChatEscalationJpaEntity jpaEntity = new ChatEscalationJpaEntity(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
        ChatEscalationJpaEntity saved = repository.save(jpaEntity);
        return toDomain(saved);
    }

    @Override
    public Optional<ChatEscalation> findById(ChatEscalationId id) {
        return repository.findById(id.value()).map(this::toDomain);
    }

    @Override
    public List<ChatEscalation> findAll() {
        return repository.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    public void deleteById(ChatEscalationId id) {
        repository.deleteById(id.value());
    }

    @Override
    public boolean existsById(ChatEscalationId id) {
        return repository.existsById(id.value());
    }

    private ChatEscalation toDomain(ChatEscalationJpaEntity jpa) {
        String entityName = jpa.getName() != null ? jpa.getName() : "Sin Nombre";
        return new ChatEscalation(
                ChatEscalationId.of(jpa.getId()),
                ChatEscalationName.of(entityName),
                ChatEscalationStatus.of(jpa.getStatus()),
                jpa.getCreatedAt(),
                jpa.getUpdatedAt()
        );
    }
}
