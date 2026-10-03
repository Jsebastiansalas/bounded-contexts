package com.demodd.domain.chat.chatparticipant.model.aggregate;

import com.demodd.domain.common.AggregateRoot;
import com.demodd.domain.chat.chatparticipant.event.ChatParticipantCreatedEvent;
import com.demodd.domain.chat.chatparticipant.event.ChatParticipantUpdatedEvent;
import com.demodd.domain.chat.chatparticipant.model.valueobject.ChatParticipantId;
import com.demodd.domain.chat.chatparticipant.model.valueobject.ChatParticipantName;
import com.demodd.domain.chat.chatparticipant.model.valueobject.ChatParticipantStatus;

import java.time.Instant;
import java.util.Objects;

public class ChatParticipant extends AggregateRoot<ChatParticipantId> {

    private final ChatParticipantId id;
    private ChatParticipantName name;
    private ChatParticipantStatus status;
    private final Instant createdAt;
    private Instant updatedAt;

    public ChatParticipant(ChatParticipantId id, ChatParticipantName name, ChatParticipantStatus status, Instant createdAt, Instant updatedAt) {
        this.id = Objects.requireNonNull(id, "El identificador no puede ser nulo");
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = status != null ? status : ChatParticipantStatus.active();
        this.createdAt = createdAt != null ? createdAt : Instant.now();
        this.updatedAt = updatedAt != null ? updatedAt : Instant.now();
    }

    public static ChatParticipant create(ChatParticipantName name) {
        ChatParticipantId id = ChatParticipantId.random();
        ChatParticipant entity = new ChatParticipant(id, name, ChatParticipantStatus.active(), Instant.now(), Instant.now());
        entity.recordEvent(new ChatParticipantCreatedEvent(id.value(), entity.getCreatedAt()));
        return entity;
    }

    public void update(ChatParticipantName name, ChatParticipantStatus status) {
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = Objects.requireNonNull(status, "El estado no puede ser nulo");
        this.updatedAt = Instant.now();
        recordEvent(new ChatParticipantUpdatedEvent(this.id.value(), this.updatedAt));
    }

    @Override
    public ChatParticipantId getId() {
        return id;
    }

    public ChatParticipantName getName() {
        return name;
    }

    public ChatParticipantStatus getStatus() {
        return status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
