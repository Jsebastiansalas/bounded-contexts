package com.demodd.domain.clinical.treatmentstatus.model.aggregate;

import com.demodd.domain.common.AggregateRoot;
import com.demodd.domain.clinical.treatmentstatus.event.TreatmentStatusCreatedEvent;
import com.demodd.domain.clinical.treatmentstatus.event.TreatmentStatusUpdatedEvent;
import com.demodd.domain.clinical.treatmentstatus.model.valueobject.TreatmentStatusId;
import com.demodd.domain.clinical.treatmentstatus.model.valueobject.TreatmentStatusName;
import com.demodd.domain.clinical.treatmentstatus.model.valueobject.TreatmentStatusStatus;

import java.time.Instant;
import java.util.Objects;

public class TreatmentStatus extends AggregateRoot<TreatmentStatusId> {

    private final TreatmentStatusId id;
    private TreatmentStatusName name;
    private TreatmentStatusStatus status;
    private final Instant createdAt;
    private Instant updatedAt;

    public TreatmentStatus(TreatmentStatusId id, TreatmentStatusName name, TreatmentStatusStatus status, Instant createdAt, Instant updatedAt) {
        this.id = Objects.requireNonNull(id, "El identificador no puede ser nulo");
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = status != null ? status : TreatmentStatusStatus.active();
        this.createdAt = createdAt != null ? createdAt : Instant.now();
        this.updatedAt = updatedAt != null ? updatedAt : Instant.now();
    }

    public static TreatmentStatus create(TreatmentStatusName name) {
        TreatmentStatusId id = TreatmentStatusId.random();
        TreatmentStatus entity = new TreatmentStatus(id, name, TreatmentStatusStatus.active(), Instant.now(), Instant.now());
        entity.recordEvent(new TreatmentStatusCreatedEvent(id.value(), entity.getCreatedAt()));
        return entity;
    }

    public void update(TreatmentStatusName name, TreatmentStatusStatus status) {
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = Objects.requireNonNull(status, "El estado no puede ser nulo");
        this.updatedAt = Instant.now();
        recordEvent(new TreatmentStatusUpdatedEvent(this.id.value(), this.updatedAt));
    }

    @Override
    public TreatmentStatusId getId() {
        return id;
    }

    public TreatmentStatusName getName() {
        return name;
    }

    public TreatmentStatusStatus getStatus() {
        return status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
