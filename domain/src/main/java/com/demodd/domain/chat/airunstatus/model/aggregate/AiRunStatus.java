package com.demodd.domain.chat.airunstatus.model.aggregate;

import com.demodd.domain.common.AggregateRoot;
import com.demodd.domain.chat.airunstatus.event.AiRunStatusCreatedEvent;
import com.demodd.domain.chat.airunstatus.event.AiRunStatusUpdatedEvent;
import com.demodd.domain.chat.airunstatus.model.valueobject.AiRunStatusId;
import com.demodd.domain.chat.airunstatus.model.valueobject.AiRunStatusName;
import com.demodd.domain.chat.airunstatus.model.valueobject.AiRunStatusStatus;

import java.time.Instant;
import java.util.Objects;

public class AiRunStatus extends AggregateRoot<AiRunStatusId> {

    private final AiRunStatusId id;
    private AiRunStatusName name;
    private AiRunStatusStatus status;
    private final Instant createdAt;
    private Instant updatedAt;

    public AiRunStatus(AiRunStatusId id, AiRunStatusName name, AiRunStatusStatus status, Instant createdAt, Instant updatedAt) {
        this.id = Objects.requireNonNull(id, "El identificador no puede ser nulo");
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = status != null ? status : AiRunStatusStatus.active();
        this.createdAt = createdAt != null ? createdAt : Instant.now();
        this.updatedAt = updatedAt != null ? updatedAt : Instant.now();
    }

    public static AiRunStatus create(AiRunStatusName name) {
        AiRunStatusId id = AiRunStatusId.random();
        AiRunStatus entity = new AiRunStatus(id, name, AiRunStatusStatus.active(), Instant.now(), Instant.now());
        entity.recordEvent(new AiRunStatusCreatedEvent(id.value(), entity.getCreatedAt()));
        return entity;
    }

    public void update(AiRunStatusName name, AiRunStatusStatus status) {
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = Objects.requireNonNull(status, "El estado no puede ser nulo");
        this.updatedAt = Instant.now();
        recordEvent(new AiRunStatusUpdatedEvent(this.id.value(), this.updatedAt));
    }

    @Override
    public AiRunStatusId getId() {
        return id;
    }

    public AiRunStatusName getName() {
        return name;
    }

    public AiRunStatusStatus getStatus() {
        return status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
