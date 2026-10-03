package com.demodd.domain.clinical.encounterstatus.model.aggregate;

import com.demodd.domain.common.AggregateRoot;
import com.demodd.domain.clinical.encounterstatus.event.EncounterStatusCreatedEvent;
import com.demodd.domain.clinical.encounterstatus.event.EncounterStatusUpdatedEvent;
import com.demodd.domain.clinical.encounterstatus.model.valueobject.EncounterStatusId;
import com.demodd.domain.clinical.encounterstatus.model.valueobject.EncounterStatusName;
import com.demodd.domain.clinical.encounterstatus.model.valueobject.EncounterStatusStatus;

import java.time.Instant;
import java.util.Objects;

public class EncounterStatus extends AggregateRoot<EncounterStatusId> {

    private final EncounterStatusId id;
    private EncounterStatusName name;
    private EncounterStatusStatus status;
    private final Instant createdAt;
    private Instant updatedAt;

    public EncounterStatus(EncounterStatusId id, EncounterStatusName name, EncounterStatusStatus status, Instant createdAt, Instant updatedAt) {
        this.id = Objects.requireNonNull(id, "El identificador no puede ser nulo");
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = status != null ? status : EncounterStatusStatus.active();
        this.createdAt = createdAt != null ? createdAt : Instant.now();
        this.updatedAt = updatedAt != null ? updatedAt : Instant.now();
    }

    public static EncounterStatus create(EncounterStatusName name) {
        EncounterStatusId id = EncounterStatusId.random();
        EncounterStatus entity = new EncounterStatus(id, name, EncounterStatusStatus.active(), Instant.now(), Instant.now());
        entity.recordEvent(new EncounterStatusCreatedEvent(id.value(), entity.getCreatedAt()));
        return entity;
    }

    public void update(EncounterStatusName name, EncounterStatusStatus status) {
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = Objects.requireNonNull(status, "El estado no puede ser nulo");
        this.updatedAt = Instant.now();
        recordEvent(new EncounterStatusUpdatedEvent(this.id.value(), this.updatedAt));
    }

    @Override
    public EncounterStatusId getId() {
        return id;
    }

    public EncounterStatusName getName() {
        return name;
    }

    public EncounterStatusStatus getStatus() {
        return status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
