package com.demodd.domain.chat.chatconversation.model.aggregate;

import com.demodd.domain.common.AggregateRoot;
import com.demodd.domain.chat.chatconversation.event.ChatConversationCreatedEvent;
import com.demodd.domain.chat.chatconversation.event.ChatConversationUpdatedEvent;
import com.demodd.domain.chat.chatconversation.model.valueobject.ChatConversationId;
import com.demodd.domain.chat.chatconversation.model.valueobject.ChatConversationName;
import com.demodd.domain.chat.chatconversation.model.valueobject.ChatConversationStatus;

import java.time.Instant;
import java.util.Objects;

public class ChatConversation extends AggregateRoot<ChatConversationId> {

    private final ChatConversationId id;
    private ChatConversationName name;
    private ChatConversationStatus status;
    private final Instant createdAt;
    private Instant updatedAt;

    public ChatConversation(ChatConversationId id, ChatConversationName name, ChatConversationStatus status, Instant createdAt, Instant updatedAt) {
        this.id = Objects.requireNonNull(id, "El identificador no puede ser nulo");
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = status != null ? status : ChatConversationStatus.active();
        this.createdAt = createdAt != null ? createdAt : Instant.now();
        this.updatedAt = updatedAt != null ? updatedAt : Instant.now();
    }

    public static ChatConversation create(ChatConversationName name) {
        ChatConversationId id = ChatConversationId.random();
        ChatConversation entity = new ChatConversation(id, name, ChatConversationStatus.active(), Instant.now(), Instant.now());
        entity.recordEvent(new ChatConversationCreatedEvent(id.value(), entity.getCreatedAt()));
        return entity;
    }

    public void update(ChatConversationName name, ChatConversationStatus status) {
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = Objects.requireNonNull(status, "El estado no puede ser nulo");
        this.updatedAt = Instant.now();
        recordEvent(new ChatConversationUpdatedEvent(this.id.value(), this.updatedAt));
    }

    @Override
    public ChatConversationId getId() {
        return id;
    }

    public ChatConversationName getName() {
        return name;
    }

    public ChatConversationStatus getStatus() {
        return status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
