package com.demodd.infrastructure.chat.chatescalationassignment.adapter.out.persistence;

import com.demodd.domain.chat.chatescalationassignment.model.aggregate.ChatEscalationAssignment;
import com.demodd.domain.chat.chatescalationassignment.model.valueobject.ChatEscalationAssignmentId;
import com.demodd.domain.chat.chatescalationassignment.model.valueobject.ChatEscalationAssignmentName;
import com.demodd.domain.chat.chatescalationassignment.model.valueobject.ChatEscalationAssignmentStatus;
import com.demodd.domain.chat.chatescalationassignment.port.repository.ChatEscalationAssignmentRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ChatEscalationAssignmentRepositoryAdapter implements ChatEscalationAssignmentRepositoryPort {

    private final ChatEscalationAssignmentSpringDataJpaRepository repository;

    public ChatEscalationAssignmentRepositoryAdapter(ChatEscalationAssignmentSpringDataJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public ChatEscalationAssignment save(ChatEscalationAssignment entity) {
        ChatEscalationAssignmentJpaEntity jpaEntity = new ChatEscalationAssignmentJpaEntity(
                entity.getId().value(),
                entity.getName().value(),
                entity.getStatus().value(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
        ChatEscalationAssignmentJpaEntity saved = repository.save(jpaEntity);
        return toDomain(saved);
    }

    @Override
    public Optional<ChatEscalationAssignment> findById(ChatEscalationAssignmentId id) {
        return repository.findById(id.value()).map(this::toDomain);
    }

    @Override
    public List<ChatEscalationAssignment> findAll() {
        return repository.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    public void deleteById(ChatEscalationAssignmentId id) {
        repository.deleteById(id.value());
    }

    @Override
    public boolean existsById(ChatEscalationAssignmentId id) {
        return repository.existsById(id.value());
    }

    private ChatEscalationAssignment toDomain(ChatEscalationAssignmentJpaEntity jpa) {
        String entityName = jpa.getName() != null ? jpa.getName() : "Sin Nombre";
        return new ChatEscalationAssignment(
                ChatEscalationAssignmentId.of(jpa.getId()),
                ChatEscalationAssignmentName.of(entityName),
                ChatEscalationAssignmentStatus.of(jpa.getStatus()),
                jpa.getCreatedAt(),
                jpa.getUpdatedAt()
        );
    }
}
