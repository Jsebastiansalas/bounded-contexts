package com.demodd.domain.clinical.encounter.model.aggregate;

import com.demodd.domain.common.AggregateRoot;
import com.demodd.domain.clinical.encounter.event.EncounterCreatedEvent;
import com.demodd.domain.clinical.encounter.event.EncounterUpdatedEvent;
import com.demodd.domain.clinical.encounter.model.valueobject.EncounterId;
import com.demodd.domain.clinical.encounter.model.valueobject.EncounterName;
import com.demodd.domain.clinical.encounter.model.valueobject.EncounterStatus;

import java.time.Instant;
import java.util.Objects;

public class Encounter extends AggregateRoot<EncounterId> {

    private final EncounterId id;
    private EncounterName name;
    private EncounterStatus status;
    private final Instant createdAt;
    private Instant updatedAt;

    public Encounter(EncounterId id, EncounterName name, EncounterStatus status, Instant createdAt, Instant updatedAt) {
        this.id = Objects.requireNonNull(id, "El identificador no puede ser nulo");
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = status != null ? status : EncounterStatus.active();
        this.createdAt = createdAt != null ? createdAt : Instant.now();
        this.updatedAt = updatedAt != null ? updatedAt : Instant.now();
    }

    public static Encounter create(EncounterName name) {
        EncounterId id = EncounterId.random();
        Encounter entity = new Encounter(id, name, EncounterStatus.active(), Instant.now(), Instant.now());
        entity.recordEvent(new EncounterCreatedEvent(id.value(), entity.getCreatedAt()));
        return entity;
    }

    public void update(EncounterName name, EncounterStatus status) {
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = Objects.requireNonNull(status, "El estado no puede ser nulo");
        this.updatedAt = Instant.now();
        recordEvent(new EncounterUpdatedEvent(this.id.value(), this.updatedAt));
    }

    @Override
    public EncounterId getId() {
        return id;
    }

    public EncounterName getName() {
        return name;
    }

    public EncounterStatus getStatus() {
        return status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
