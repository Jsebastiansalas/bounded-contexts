package com.demodd.domain.clinical.encountertype.model.aggregate;

import com.demodd.domain.common.AggregateRoot;
import com.demodd.domain.clinical.encountertype.event.EncounterTypeCreatedEvent;
import com.demodd.domain.clinical.encountertype.event.EncounterTypeUpdatedEvent;
import com.demodd.domain.clinical.encountertype.model.valueobject.EncounterTypeId;
import com.demodd.domain.clinical.encountertype.model.valueobject.EncounterTypeName;
import com.demodd.domain.clinical.encountertype.model.valueobject.EncounterTypeStatus;

import java.time.Instant;
import java.util.Objects;

public class EncounterType extends AggregateRoot<EncounterTypeId> {

    private final EncounterTypeId id;
    private EncounterTypeName name;
    private EncounterTypeStatus status;
    private final Instant createdAt;
    private Instant updatedAt;

    public EncounterType(EncounterTypeId id, EncounterTypeName name, EncounterTypeStatus status, Instant createdAt, Instant updatedAt) {
        this.id = Objects.requireNonNull(id, "El identificador no puede ser nulo");
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = status != null ? status : EncounterTypeStatus.active();
        this.createdAt = createdAt != null ? createdAt : Instant.now();
        this.updatedAt = updatedAt != null ? updatedAt : Instant.now();
    }

    public static EncounterType create(EncounterTypeName name) {
        EncounterTypeId id = EncounterTypeId.random();
        EncounterType entity = new EncounterType(id, name, EncounterTypeStatus.active(), Instant.now(), Instant.now());
        entity.recordEvent(new EncounterTypeCreatedEvent(id.value(), entity.getCreatedAt()));
        return entity;
    }

    public void update(EncounterTypeName name, EncounterTypeStatus status) {
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = Objects.requireNonNull(status, "El estado no puede ser nulo");
        this.updatedAt = Instant.now();
        recordEvent(new EncounterTypeUpdatedEvent(this.id.value(), this.updatedAt));
    }

    @Override
    public EncounterTypeId getId() {
        return id;
    }

    public EncounterTypeName getName() {
        return name;
    }

    public EncounterTypeStatus getStatus() {
        return status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
