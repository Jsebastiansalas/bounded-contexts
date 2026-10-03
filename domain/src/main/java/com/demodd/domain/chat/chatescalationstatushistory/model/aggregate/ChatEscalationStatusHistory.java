package com.demodd.domain.chat.chatescalationstatushistory.model.aggregate;

import com.demodd.domain.common.AggregateRoot;
import com.demodd.domain.chat.chatescalationstatushistory.event.ChatEscalationStatusHistoryCreatedEvent;
import com.demodd.domain.chat.chatescalationstatushistory.event.ChatEscalationStatusHistoryUpdatedEvent;
import com.demodd.domain.chat.chatescalationstatushistory.model.valueobject.ChatEscalationStatusHistoryId;
import com.demodd.domain.chat.chatescalationstatushistory.model.valueobject.ChatEscalationStatusHistoryName;
import com.demodd.domain.chat.chatescalationstatushistory.model.valueobject.ChatEscalationStatusHistoryStatus;

import java.time.Instant;
import java.util.Objects;

public class ChatEscalationStatusHistory extends AggregateRoot<ChatEscalationStatusHistoryId> {

    private final ChatEscalationStatusHistoryId id;
    private ChatEscalationStatusHistoryName name;
    private ChatEscalationStatusHistoryStatus status;
    private final Instant createdAt;
    private Instant updatedAt;

    public ChatEscalationStatusHistory(ChatEscalationStatusHistoryId id, ChatEscalationStatusHistoryName name, ChatEscalationStatusHistoryStatus status, Instant createdAt, Instant updatedAt) {
        this.id = Objects.requireNonNull(id, "El identificador no puede ser nulo");
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = status != null ? status : ChatEscalationStatusHistoryStatus.active();
        this.createdAt = createdAt != null ? createdAt : Instant.now();
        this.updatedAt = updatedAt != null ? updatedAt : Instant.now();
    }

    public static ChatEscalationStatusHistory create(ChatEscalationStatusHistoryName name) {
        ChatEscalationStatusHistoryId id = ChatEscalationStatusHistoryId.random();
        ChatEscalationStatusHistory entity = new ChatEscalationStatusHistory(id, name, ChatEscalationStatusHistoryStatus.active(), Instant.now(), Instant.now());
        entity.recordEvent(new ChatEscalationStatusHistoryCreatedEvent(id.value(), entity.getCreatedAt()));
        return entity;
    }

    public void update(ChatEscalationStatusHistoryName name, ChatEscalationStatusHistoryStatus status) {
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = Objects.requireNonNull(status, "El estado no puede ser nulo");
        this.updatedAt = Instant.now();
        recordEvent(new ChatEscalationStatusHistoryUpdatedEvent(this.id.value(), this.updatedAt));
    }

    @Override
    public ChatEscalationStatusHistoryId getId() {
        return id;
    }

    public ChatEscalationStatusHistoryName getName() {
        return name;
    }

    public ChatEscalationStatusHistoryStatus getStatus() {
        return status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
