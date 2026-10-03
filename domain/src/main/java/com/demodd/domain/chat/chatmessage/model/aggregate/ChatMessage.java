package com.demodd.domain.chat.chatmessage.model.aggregate;

import com.demodd.domain.common.AggregateRoot;
import com.demodd.domain.chat.chatmessage.event.ChatMessageCreatedEvent;
import com.demodd.domain.chat.chatmessage.event.ChatMessageUpdatedEvent;
import com.demodd.domain.chat.chatmessage.model.valueobject.ChatMessageId;
import com.demodd.domain.chat.chatmessage.model.valueobject.ChatMessageName;
import com.demodd.domain.chat.chatmessage.model.valueobject.ChatMessageStatus;

import java.time.Instant;
import java.util.Objects;

public class ChatMessage extends AggregateRoot<ChatMessageId> {

    private final ChatMessageId id;
    private ChatMessageName name;
    private ChatMessageStatus status;
    private final Instant createdAt;
    private Instant updatedAt;

    public ChatMessage(ChatMessageId id, ChatMessageName name, ChatMessageStatus status, Instant createdAt, Instant updatedAt) {
        this.id = Objects.requireNonNull(id, "El identificador no puede ser nulo");
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = status != null ? status : ChatMessageStatus.active();
        this.createdAt = createdAt != null ? createdAt : Instant.now();
        this.updatedAt = updatedAt != null ? updatedAt : Instant.now();
    }

    public static ChatMessage create(ChatMessageName name) {
        ChatMessageId id = ChatMessageId.random();
        ChatMessage entity = new ChatMessage(id, name, ChatMessageStatus.active(), Instant.now(), Instant.now());
        entity.recordEvent(new ChatMessageCreatedEvent(id.value(), entity.getCreatedAt()));
        return entity;
    }

    public void update(ChatMessageName name, ChatMessageStatus status) {
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = Objects.requireNonNull(status, "El estado no puede ser nulo");
        this.updatedAt = Instant.now();
        recordEvent(new ChatMessageUpdatedEvent(this.id.value(), this.updatedAt));
    }

    @Override
    public ChatMessageId getId() {
        return id;
    }

    public ChatMessageName getName() {
        return name;
    }

    public ChatMessageStatus getStatus() {
        return status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
