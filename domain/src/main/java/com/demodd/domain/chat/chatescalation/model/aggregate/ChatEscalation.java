package com.demodd.domain.chat.chatescalation.model.aggregate;

import com.demodd.domain.common.AggregateRoot;
import com.demodd.domain.chat.chatescalation.event.ChatEscalationCreatedEvent;
import com.demodd.domain.chat.chatescalation.event.ChatEscalationUpdatedEvent;
import com.demodd.domain.chat.chatescalation.model.valueobject.ChatEscalationId;
import com.demodd.domain.chat.chatescalation.model.valueobject.ChatEscalationName;
import com.demodd.domain.chat.chatescalation.model.valueobject.ChatEscalationStatus;

import java.time.Instant;
import java.util.Objects;

public class ChatEscalation extends AggregateRoot<ChatEscalationId> {

    private final ChatEscalationId id;
    private ChatEscalationName name;
    private ChatEscalationStatus status;
    private final Instant createdAt;
    private Instant updatedAt;

    public ChatEscalation(ChatEscalationId id, ChatEscalationName name, ChatEscalationStatus status, Instant createdAt, Instant updatedAt) {
        this.id = Objects.requireNonNull(id, "El identificador no puede ser nulo");
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = status != null ? status : ChatEscalationStatus.active();
        this.createdAt = createdAt != null ? createdAt : Instant.now();
        this.updatedAt = updatedAt != null ? updatedAt : Instant.now();
    }

    public static ChatEscalation create(ChatEscalationName name) {
        ChatEscalationId id = ChatEscalationId.random();
        ChatEscalation entity = new ChatEscalation(id, name, ChatEscalationStatus.active(), Instant.now(), Instant.now());
        entity.recordEvent(new ChatEscalationCreatedEvent(id.value(), entity.getCreatedAt()));
        return entity;
    }

    public void update(ChatEscalationName name, ChatEscalationStatus status) {
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = Objects.requireNonNull(status, "El estado no puede ser nulo");
        this.updatedAt = Instant.now();
        recordEvent(new ChatEscalationUpdatedEvent(this.id.value(), this.updatedAt));
    }

    @Override
    public ChatEscalationId getId() {
        return id;
    }

    public ChatEscalationName getName() {
        return name;
    }

    public ChatEscalationStatus getStatus() {
        return status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
