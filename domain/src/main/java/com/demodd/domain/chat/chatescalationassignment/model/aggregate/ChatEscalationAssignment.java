package com.demodd.domain.chat.chatescalationassignment.model.aggregate;

import com.demodd.domain.common.AggregateRoot;
import com.demodd.domain.chat.chatescalationassignment.event.ChatEscalationAssignmentCreatedEvent;
import com.demodd.domain.chat.chatescalationassignment.event.ChatEscalationAssignmentUpdatedEvent;
import com.demodd.domain.chat.chatescalationassignment.model.valueobject.ChatEscalationAssignmentId;
import com.demodd.domain.chat.chatescalationassignment.model.valueobject.ChatEscalationAssignmentName;
import com.demodd.domain.chat.chatescalationassignment.model.valueobject.ChatEscalationAssignmentStatus;

import java.time.Instant;
import java.util.Objects;

public class ChatEscalationAssignment extends AggregateRoot<ChatEscalationAssignmentId> {

    private final ChatEscalationAssignmentId id;
    private ChatEscalationAssignmentName name;
    private ChatEscalationAssignmentStatus status;
    private final Instant createdAt;
    private Instant updatedAt;

    public ChatEscalationAssignment(ChatEscalationAssignmentId id, ChatEscalationAssignmentName name, ChatEscalationAssignmentStatus status, Instant createdAt, Instant updatedAt) {
        this.id = Objects.requireNonNull(id, "El identificador no puede ser nulo");
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = status != null ? status : ChatEscalationAssignmentStatus.active();
        this.createdAt = createdAt != null ? createdAt : Instant.now();
        this.updatedAt = updatedAt != null ? updatedAt : Instant.now();
    }

    public static ChatEscalationAssignment create(ChatEscalationAssignmentName name) {
        ChatEscalationAssignmentId id = ChatEscalationAssignmentId.random();
        ChatEscalationAssignment entity = new ChatEscalationAssignment(id, name, ChatEscalationAssignmentStatus.active(), Instant.now(), Instant.now());
        entity.recordEvent(new ChatEscalationAssignmentCreatedEvent(id.value(), entity.getCreatedAt()));
        return entity;
    }

    public void update(ChatEscalationAssignmentName name, ChatEscalationAssignmentStatus status) {
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = Objects.requireNonNull(status, "El estado no puede ser nulo");
        this.updatedAt = Instant.now();
        recordEvent(new ChatEscalationAssignmentUpdatedEvent(this.id.value(), this.updatedAt));
    }

    @Override
    public ChatEscalationAssignmentId getId() {
        return id;
    }

    public ChatEscalationAssignmentName getName() {
        return name;
    }

    public ChatEscalationAssignmentStatus getStatus() {
        return status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
