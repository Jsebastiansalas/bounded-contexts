package com.demodd.infrastructure.chat.chatairun.adapter.out.persistence;

import com.demodd.domain.chat.chatairun.model.aggregate.ChatAiRun;
import com.demodd.domain.chat.chatairun.model.valueobject.ChatAiRunId;
import com.demodd.domain.chat.chatairun.model.valueobject.ChatAiRunName;
import com.demodd.domain.chat.chatairun.model.valueobject.ChatAiRunStatus;
import com.demodd.domain.chat.chatairun.port.repository.ChatAiRunRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ChatAiRunRepositoryAdapter implements ChatAiRunRepositoryPort {

    private final ChatAiRunSpringDataJpaRepository repository;

    public ChatAiRunRepositoryAdapter(ChatAiRunSpringDataJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public ChatAiRun save(ChatAiRun entity) {
        ChatAiRunJpaEntity jpaEntity = new ChatAiRunJpaEntity(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
        ChatAiRunJpaEntity saved = repository.save(jpaEntity);
        return toDomain(saved);
    }

    @Override
    public Optional<ChatAiRun> findById(ChatAiRunId id) {
        return repository.findById(id.value()).map(this::toDomain);
    }

    @Override
    public List<ChatAiRun> findAll() {
        return repository.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    public void deleteById(ChatAiRunId id) {
        repository.deleteById(id.value());
    }

    @Override
    public boolean existsById(ChatAiRunId id) {
        return repository.existsById(id.value());
    }

    private ChatAiRun toDomain(ChatAiRunJpaEntity jpa) {
        String entityName = jpa.getName() != null ? jpa.getName() : "Sin Nombre";
        return new ChatAiRun(
                ChatAiRunId.of(jpa.getId()),
                ChatAiRunName.of(entityName),
                ChatAiRunStatus.of(jpa.getStatus()),
                jpa.getCreatedAt(),
                jpa.getUpdatedAt()
        );
    }
}
