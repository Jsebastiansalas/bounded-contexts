package com.demodd.domain.clinical.treatmentgoalstatus.model.aggregate;

import com.demodd.domain.common.AggregateRoot;
import com.demodd.domain.clinical.treatmentgoalstatus.event.TreatmentGoalStatusCreatedEvent;
import com.demodd.domain.clinical.treatmentgoalstatus.event.TreatmentGoalStatusUpdatedEvent;
import com.demodd.domain.clinical.treatmentgoalstatus.model.valueobject.TreatmentGoalStatusId;
import com.demodd.domain.clinical.treatmentgoalstatus.model.valueobject.TreatmentGoalStatusName;
import com.demodd.domain.clinical.treatmentgoalstatus.model.valueobject.TreatmentGoalStatusStatus;

import java.time.Instant;
import java.util.Objects;

public class TreatmentGoalStatus extends AggregateRoot<TreatmentGoalStatusId> {

    private final TreatmentGoalStatusId id;
    private TreatmentGoalStatusName name;
    private TreatmentGoalStatusStatus status;
    private final Instant createdAt;
    private Instant updatedAt;

    public TreatmentGoalStatus(TreatmentGoalStatusId id, TreatmentGoalStatusName name, TreatmentGoalStatusStatus status, Instant createdAt, Instant updatedAt) {
        this.id = Objects.requireNonNull(id, "El identificador no puede ser nulo");
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = status != null ? status : TreatmentGoalStatusStatus.active();
        this.createdAt = createdAt != null ? createdAt : Instant.now();
        this.updatedAt = updatedAt != null ? updatedAt : Instant.now();
    }

    public static TreatmentGoalStatus create(TreatmentGoalStatusName name) {
        TreatmentGoalStatusId id = TreatmentGoalStatusId.random();
        TreatmentGoalStatus entity = new TreatmentGoalStatus(id, name, TreatmentGoalStatusStatus.active(), Instant.now(), Instant.now());
        entity.recordEvent(new TreatmentGoalStatusCreatedEvent(id.value(), entity.getCreatedAt()));
        return entity;
    }

    public void update(TreatmentGoalStatusName name, TreatmentGoalStatusStatus status) {
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = Objects.requireNonNull(status, "El estado no puede ser nulo");
        this.updatedAt = Instant.now();
        recordEvent(new TreatmentGoalStatusUpdatedEvent(this.id.value(), this.updatedAt));
    }

    @Override
    public TreatmentGoalStatusId getId() {
        return id;
    }

    public TreatmentGoalStatusName getName() {
        return name;
    }

    public TreatmentGoalStatusStatus getStatus() {
        return status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
