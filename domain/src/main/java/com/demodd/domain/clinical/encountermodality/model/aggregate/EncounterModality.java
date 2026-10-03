package com.demodd.domain.clinical.encountermodality.model.aggregate;

import com.demodd.domain.common.AggregateRoot;
import com.demodd.domain.clinical.encountermodality.event.EncounterModalityCreatedEvent;
import com.demodd.domain.clinical.encountermodality.event.EncounterModalityUpdatedEvent;
import com.demodd.domain.clinical.encountermodality.model.valueobject.EncounterModalityId;
import com.demodd.domain.clinical.encountermodality.model.valueobject.EncounterModalityName;
import com.demodd.domain.clinical.encountermodality.model.valueobject.EncounterModalityStatus;

import java.time.Instant;
import java.util.Objects;

public class EncounterModality extends AggregateRoot<EncounterModalityId> {

    private final EncounterModalityId id;
    private EncounterModalityName name;
    private EncounterModalityStatus status;
    private final Instant createdAt;
    private Instant updatedAt;

    public EncounterModality(EncounterModalityId id, EncounterModalityName name, EncounterModalityStatus status, Instant createdAt, Instant updatedAt) {
        this.id = Objects.requireNonNull(id, "El identificador no puede ser nulo");
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = status != null ? status : EncounterModalityStatus.active();
        this.createdAt = createdAt != null ? createdAt : Instant.now();
        this.updatedAt = updatedAt != null ? updatedAt : Instant.now();
    }

    public static EncounterModality create(EncounterModalityName name) {
        EncounterModalityId id = EncounterModalityId.random();
        EncounterModality entity = new EncounterModality(id, name, EncounterModalityStatus.active(), Instant.now(), Instant.now());
        entity.recordEvent(new EncounterModalityCreatedEvent(id.value(), entity.getCreatedAt()));
        return entity;
    }

    public void update(EncounterModalityName name, EncounterModalityStatus status) {
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = Objects.requireNonNull(status, "El estado no puede ser nulo");
        this.updatedAt = Instant.now();
        recordEvent(new EncounterModalityUpdatedEvent(this.id.value(), this.updatedAt));
    }

    @Override
    public EncounterModalityId getId() {
        return id;
    }

    public EncounterModalityName getName() {
        return name;
    }

    public EncounterModalityStatus getStatus() {
        return status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
