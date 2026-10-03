package com.demodd.domain.chat.messagetype.model.aggregate;

import com.demodd.domain.common.AggregateRoot;
import com.demodd.domain.chat.messagetype.event.MessageTypeCreatedEvent;
import com.demodd.domain.chat.messagetype.event.MessageTypeUpdatedEvent;
import com.demodd.domain.chat.messagetype.model.valueobject.MessageTypeId;
import com.demodd.domain.chat.messagetype.model.valueobject.MessageTypeName;
import com.demodd.domain.chat.messagetype.model.valueobject.MessageTypeStatus;

import java.time.Instant;
import java.util.Objects;

public class MessageType extends AggregateRoot<MessageTypeId> {

    private final MessageTypeId id;
    private MessageTypeName name;
    private MessageTypeStatus status;
    private final Instant createdAt;
    private Instant updatedAt;

    public MessageType(MessageTypeId id, MessageTypeName name, MessageTypeStatus status, Instant createdAt, Instant updatedAt) {
        this.id = Objects.requireNonNull(id, "El identificador no puede ser nulo");
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = status != null ? status : MessageTypeStatus.active();
        this.createdAt = createdAt != null ? createdAt : Instant.now();
        this.updatedAt = updatedAt != null ? updatedAt : Instant.now();
    }

    public static MessageType create(MessageTypeName name) {
        MessageTypeId id = MessageTypeId.random();
        MessageType entity = new MessageType(id, name, MessageTypeStatus.active(), Instant.now(), Instant.now());
        entity.recordEvent(new MessageTypeCreatedEvent(id.value(), entity.getCreatedAt()));
        return entity;
    }

    public void update(MessageTypeName name, MessageTypeStatus status) {
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = Objects.requireNonNull(status, "El estado no puede ser nulo");
        this.updatedAt = Instant.now();
        recordEvent(new MessageTypeUpdatedEvent(this.id.value(), this.updatedAt));
    }

    @Override
    public MessageTypeId getId() {
        return id;
    }

    public MessageTypeName getName() {
        return name;
    }

    public MessageTypeStatus getStatus() {
        return status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
