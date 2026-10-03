package com.demodd.domain.chat.chatairun.model.aggregate;

import com.demodd.domain.common.AggregateRoot;
import com.demodd.domain.chat.chatairun.event.ChatAiRunCreatedEvent;
import com.demodd.domain.chat.chatairun.event.ChatAiRunUpdatedEvent;
import com.demodd.domain.chat.chatairun.model.valueobject.ChatAiRunId;
import com.demodd.domain.chat.chatairun.model.valueobject.ChatAiRunName;
import com.demodd.domain.chat.chatairun.model.valueobject.ChatAiRunStatus;

import java.time.Instant;
import java.util.Objects;

public class ChatAiRun extends AggregateRoot<ChatAiRunId> {

    private final ChatAiRunId id;
    private ChatAiRunName name;
    private ChatAiRunStatus status;
    private final Instant createdAt;
    private Instant updatedAt;

    public ChatAiRun(ChatAiRunId id, ChatAiRunName name, ChatAiRunStatus status, Instant createdAt, Instant updatedAt) {
        this.id = Objects.requireNonNull(id, "El identificador no puede ser nulo");
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = status != null ? status : ChatAiRunStatus.active();
        this.createdAt = createdAt != null ? createdAt : Instant.now();
        this.updatedAt = updatedAt != null ? updatedAt : Instant.now();
    }

    public static ChatAiRun create(ChatAiRunName name) {
        ChatAiRunId id = ChatAiRunId.random();
        ChatAiRun entity = new ChatAiRun(id, name, ChatAiRunStatus.active(), Instant.now(), Instant.now());
        entity.recordEvent(new ChatAiRunCreatedEvent(id.value(), entity.getCreatedAt()));
        return entity;
    }

    public void update(ChatAiRunName name, ChatAiRunStatus status) {
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = Objects.requireNonNull(status, "El estado no puede ser nulo");
        this.updatedAt = Instant.now();
        recordEvent(new ChatAiRunUpdatedEvent(this.id.value(), this.updatedAt));
    }

    @Override
    public ChatAiRunId getId() {
        return id;
    }

    public ChatAiRunName getName() {
        return name;
    }

    public ChatAiRunStatus getStatus() {
        return status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
