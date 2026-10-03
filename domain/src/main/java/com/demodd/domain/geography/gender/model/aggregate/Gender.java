package com.demodd.domain.geography.gender.model.aggregate;

import com.demodd.domain.common.AggregateRoot;
import com.demodd.domain.geography.gender.event.GenderCreatedEvent;
import com.demodd.domain.geography.gender.event.GenderUpdatedEvent;
import com.demodd.domain.geography.gender.model.valueobject.GenderId;
import com.demodd.domain.geography.gender.model.valueobject.GenderName;
import com.demodd.domain.geography.gender.model.valueobject.GenderStatus;

import java.time.Instant;
import java.util.Objects;

public class Gender extends AggregateRoot<GenderId> {

    private final GenderId id;
    private GenderName name;
    private GenderStatus status;
    private final Instant createdAt;
    private Instant updatedAt;

    public Gender(GenderId id, GenderName name, GenderStatus status, Instant createdAt, Instant updatedAt) {
        this.id = Objects.requireNonNull(id, "El identificador no puede ser nulo");
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = status != null ? status : GenderStatus.active();
        this.createdAt = createdAt != null ? createdAt : Instant.now();
        this.updatedAt = updatedAt != null ? updatedAt : Instant.now();
    }

    public static Gender create(GenderName name) {
        GenderId id = GenderId.random();
        Gender entity = new Gender(id, name, GenderStatus.active(), Instant.now(), Instant.now());
        entity.recordEvent(new GenderCreatedEvent(id.value(), entity.getCreatedAt()));
        return entity;
    }

    public void update(GenderName name, GenderStatus status) {
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = Objects.requireNonNull(status, "El estado no puede ser nulo");
        this.updatedAt = Instant.now();
        recordEvent(new GenderUpdatedEvent(this.id.value(), this.updatedAt));
    }

    @Override
    public GenderId getId() {
        return id;
    }

    public GenderName getName() {
        return name;
    }

    public GenderStatus getStatus() {
        return status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
