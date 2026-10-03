package com.demodd.domain.chat.escalationstatus.model.aggregate;

import com.demodd.domain.common.AggregateRoot;
import com.demodd.domain.chat.escalationstatus.event.EscalationStatusCreatedEvent;
import com.demodd.domain.chat.escalationstatus.event.EscalationStatusUpdatedEvent;
import com.demodd.domain.chat.escalationstatus.model.valueobject.EscalationStatusId;
import com.demodd.domain.chat.escalationstatus.model.valueobject.EscalationStatusName;
import com.demodd.domain.chat.escalationstatus.model.valueobject.EscalationStatusStatus;

import java.time.Instant;
import java.util.Objects;

public class EscalationStatus extends AggregateRoot<EscalationStatusId> {

    private final EscalationStatusId id;
    private EscalationStatusName name;
    private EscalationStatusStatus status;
    private final Instant createdAt;
    private Instant updatedAt;

    public EscalationStatus(EscalationStatusId id, EscalationStatusName name, EscalationStatusStatus status, Instant createdAt, Instant updatedAt) {
        this.id = Objects.requireNonNull(id, "El identificador no puede ser nulo");
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = status != null ? status : EscalationStatusStatus.active();
        this.createdAt = createdAt != null ? createdAt : Instant.now();
        this.updatedAt = updatedAt != null ? updatedAt : Instant.now();
    }

    public static EscalationStatus create(EscalationStatusName name) {
        EscalationStatusId id = EscalationStatusId.random();
        EscalationStatus entity = new EscalationStatus(id, name, EscalationStatusStatus.active(), Instant.now(), Instant.now());
        entity.recordEvent(new EscalationStatusCreatedEvent(id.value(), entity.getCreatedAt()));
        return entity;
    }

    public void update(EscalationStatusName name, EscalationStatusStatus status) {
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = Objects.requireNonNull(status, "El estado no puede ser nulo");
        this.updatedAt = Instant.now();
        recordEvent(new EscalationStatusUpdatedEvent(this.id.value(), this.updatedAt));
    }

    @Override
    public EscalationStatusId getId() {
        return id;
    }

    public EscalationStatusName getName() {
        return name;
    }

    public EscalationStatusStatus getStatus() {
        return status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
