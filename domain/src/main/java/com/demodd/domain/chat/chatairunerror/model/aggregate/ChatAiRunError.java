package com.demodd.domain.chat.chatairunerror.model.aggregate;

import com.demodd.domain.common.AggregateRoot;
import com.demodd.domain.chat.chatairunerror.event.ChatAiRunErrorCreatedEvent;
import com.demodd.domain.chat.chatairunerror.event.ChatAiRunErrorUpdatedEvent;
import com.demodd.domain.chat.chatairunerror.model.valueobject.ChatAiRunErrorId;
import com.demodd.domain.chat.chatairunerror.model.valueobject.ChatAiRunErrorName;
import com.demodd.domain.chat.chatairunerror.model.valueobject.ChatAiRunErrorStatus;

import java.time.Instant;
import java.util.Objects;

public class ChatAiRunError extends AggregateRoot<ChatAiRunErrorId> {

    private final ChatAiRunErrorId id;
    private ChatAiRunErrorName name;
    private ChatAiRunErrorStatus status;
    private final Instant createdAt;
    private Instant updatedAt;

    public ChatAiRunError(ChatAiRunErrorId id, ChatAiRunErrorName name, ChatAiRunErrorStatus status, Instant createdAt, Instant updatedAt) {
        this.id = Objects.requireNonNull(id, "El identificador no puede ser nulo");
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = status != null ? status : ChatAiRunErrorStatus.active();
        this.createdAt = createdAt != null ? createdAt : Instant.now();
        this.updatedAt = updatedAt != null ? updatedAt : Instant.now();
    }

    public static ChatAiRunError create(ChatAiRunErrorName name) {
        ChatAiRunErrorId id = ChatAiRunErrorId.random();
        ChatAiRunError entity = new ChatAiRunError(id, name, ChatAiRunErrorStatus.active(), Instant.now(), Instant.now());
        entity.recordEvent(new ChatAiRunErrorCreatedEvent(id.value(), entity.getCreatedAt()));
        return entity;
    }

    public void update(ChatAiRunErrorName name, ChatAiRunErrorStatus status) {
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = Objects.requireNonNull(status, "El estado no puede ser nulo");
        this.updatedAt = Instant.now();
        recordEvent(new ChatAiRunErrorUpdatedEvent(this.id.value(), this.updatedAt));
    }

    @Override
    public ChatAiRunErrorId getId() {
        return id;
    }

    public ChatAiRunErrorName getName() {
        return name;
    }

    public ChatAiRunErrorStatus getStatus() {
        return status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
