package com.demodd.infrastructure.chat.chatescalationstatushistory.adapter.out.persistence;

import com.demodd.domain.chat.chatescalationstatushistory.model.aggregate.ChatEscalationStatusHistory;
import com.demodd.domain.chat.chatescalationstatushistory.model.valueobject.ChatEscalationStatusHistoryId;
import com.demodd.domain.chat.chatescalationstatushistory.model.valueobject.ChatEscalationStatusHistoryName;
import com.demodd.domain.chat.chatescalationstatushistory.model.valueobject.ChatEscalationStatusHistoryStatus;
import com.demodd.domain.chat.chatescalationstatushistory.port.repository.ChatEscalationStatusHistoryRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ChatEscalationStatusHistoryRepositoryAdapter implements ChatEscalationStatusHistoryRepositoryPort {

    private final ChatEscalationStatusHistorySpringDataJpaRepository repository;

    public ChatEscalationStatusHistoryRepositoryAdapter(ChatEscalationStatusHistorySpringDataJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public ChatEscalationStatusHistory save(ChatEscalationStatusHistory entity) {
        ChatEscalationStatusHistoryJpaEntity jpaEntity = new ChatEscalationStatusHistoryJpaEntity(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
        ChatEscalationStatusHistoryJpaEntity saved = repository.save(jpaEntity);
        return toDomain(saved);
    }

    @Override
    public Optional<ChatEscalationStatusHistory> findById(ChatEscalationStatusHistoryId id) {
        return repository.findById(id.value()).map(this::toDomain);
    }

    @Override
    public List<ChatEscalationStatusHistory> findAll() {
        return repository.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    public void deleteById(ChatEscalationStatusHistoryId id) {
        repository.deleteById(id.value());
    }

    @Override
    public boolean existsById(ChatEscalationStatusHistoryId id) {
        return repository.existsById(id.value());
    }

    private ChatEscalationStatusHistory toDomain(ChatEscalationStatusHistoryJpaEntity jpa) {
        String entityName = jpa.getName() != null ? jpa.getName() : "Sin Nombre";
        return new ChatEscalationStatusHistory(
                ChatEscalationStatusHistoryId.of(jpa.getId()),
                ChatEscalationStatusHistoryName.of(entityName),
                ChatEscalationStatusHistoryStatus.of(jpa.getStatus()),
                jpa.getCreatedAt(),
                jpa.getUpdatedAt()
        );
    }
}
