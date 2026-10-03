package com.demodd.domain.chat.conversationstatus.model.aggregate;

import com.demodd.domain.common.AggregateRoot;
import com.demodd.domain.chat.conversationstatus.event.ConversationStatusCreatedEvent;
import com.demodd.domain.chat.conversationstatus.event.ConversationStatusUpdatedEvent;
import com.demodd.domain.chat.conversationstatus.model.valueobject.ConversationStatusId;
import com.demodd.domain.chat.conversationstatus.model.valueobject.ConversationStatusName;
import com.demodd.domain.chat.conversationstatus.model.valueobject.ConversationStatusStatus;

import java.time.Instant;
import java.util.Objects;

public class ConversationStatus extends AggregateRoot<ConversationStatusId> {

    private final ConversationStatusId id;
    private ConversationStatusName name;
    private ConversationStatusStatus status;
    private final Instant createdAt;
    private Instant updatedAt;

    public ConversationStatus(ConversationStatusId id, ConversationStatusName name, ConversationStatusStatus status, Instant createdAt, Instant updatedAt) {
        this.id = Objects.requireNonNull(id, "El identificador no puede ser nulo");
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = status != null ? status : ConversationStatusStatus.active();
        this.createdAt = createdAt != null ? createdAt : Instant.now();
        this.updatedAt = updatedAt != null ? updatedAt : Instant.now();
    }

    public static ConversationStatus create(ConversationStatusName name) {
        ConversationStatusId id = ConversationStatusId.random();
        ConversationStatus entity = new ConversationStatus(id, name, ConversationStatusStatus.active(), Instant.now(), Instant.now());
        entity.recordEvent(new ConversationStatusCreatedEvent(id.value(), entity.getCreatedAt()));
        return entity;
    }

    public void update(ConversationStatusName name, ConversationStatusStatus status) {
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = Objects.requireNonNull(status, "El estado no puede ser nulo");
        this.updatedAt = Instant.now();
        recordEvent(new ConversationStatusUpdatedEvent(this.id.value(), this.updatedAt));
    }

    @Override
    public ConversationStatusId getId() {
        return id;
    }

    public ConversationStatusName getName() {
        return name;
    }

    public ConversationStatusStatus getStatus() {
        return status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
