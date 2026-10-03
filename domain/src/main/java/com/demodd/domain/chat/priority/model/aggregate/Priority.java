package com.demodd.domain.chat.priority.model.aggregate;

import com.demodd.domain.common.AggregateRoot;
import com.demodd.domain.chat.priority.event.PriorityCreatedEvent;
import com.demodd.domain.chat.priority.event.PriorityUpdatedEvent;
import com.demodd.domain.chat.priority.model.valueobject.PriorityId;
import com.demodd.domain.chat.priority.model.valueobject.PriorityName;
import com.demodd.domain.chat.priority.model.valueobject.PriorityStatus;

import java.time.Instant;
import java.util.Objects;

public class Priority extends AggregateRoot<PriorityId> {

    private final PriorityId id;
    private PriorityName name;
    private PriorityStatus status;
    private final Instant createdAt;
    private Instant updatedAt;

    public Priority(PriorityId id, PriorityName name, PriorityStatus status, Instant createdAt, Instant updatedAt) {
        this.id = Objects.requireNonNull(id, "El identificador no puede ser nulo");
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = status != null ? status : PriorityStatus.active();
        this.createdAt = createdAt != null ? createdAt : Instant.now();
        this.updatedAt = updatedAt != null ? updatedAt : Instant.now();
    }

    public static Priority create(PriorityName name) {
        PriorityId id = PriorityId.random();
        Priority entity = new Priority(id, name, PriorityStatus.active(), Instant.now(), Instant.now());
        entity.recordEvent(new PriorityCreatedEvent(id.value(), entity.getCreatedAt()));
        return entity;
    }

    public void update(PriorityName name, PriorityStatus status) {
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = Objects.requireNonNull(status, "El estado no puede ser nulo");
        this.updatedAt = Instant.now();
        recordEvent(new PriorityUpdatedEvent(this.id.value(), this.updatedAt));
    }

    @Override
    public PriorityId getId() {
        return id;
    }

    public PriorityName getName() {
        return name;
    }

    public PriorityStatus getStatus() {
        return status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
