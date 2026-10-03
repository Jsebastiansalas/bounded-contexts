package com.demodd.domain.clinical.treatmentgoal.model.aggregate;

import com.demodd.domain.common.AggregateRoot;
import com.demodd.domain.clinical.treatmentgoal.event.TreatmentGoalCreatedEvent;
import com.demodd.domain.clinical.treatmentgoal.event.TreatmentGoalUpdatedEvent;
import com.demodd.domain.clinical.treatmentgoal.model.valueobject.TreatmentGoalId;
import com.demodd.domain.clinical.treatmentgoal.model.valueobject.TreatmentGoalName;
import com.demodd.domain.clinical.treatmentgoal.model.valueobject.TreatmentGoalStatus;

import java.time.Instant;
import java.util.Objects;

public class TreatmentGoal extends AggregateRoot<TreatmentGoalId> {

    private final TreatmentGoalId id;
    private TreatmentGoalName name;
    private TreatmentGoalStatus status;
    private final Instant createdAt;
    private Instant updatedAt;

    public TreatmentGoal(TreatmentGoalId id, TreatmentGoalName name, TreatmentGoalStatus status, Instant createdAt, Instant updatedAt) {
        this.id = Objects.requireNonNull(id, "El identificador no puede ser nulo");
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = status != null ? status : TreatmentGoalStatus.active();
        this.createdAt = createdAt != null ? createdAt : Instant.now();
        this.updatedAt = updatedAt != null ? updatedAt : Instant.now();
    }

    public static TreatmentGoal create(TreatmentGoalName name) {
        TreatmentGoalId id = TreatmentGoalId.random();
        TreatmentGoal entity = new TreatmentGoal(id, name, TreatmentGoalStatus.active(), Instant.now(), Instant.now());
        entity.recordEvent(new TreatmentGoalCreatedEvent(id.value(), entity.getCreatedAt()));
        return entity;
    }

    public void update(TreatmentGoalName name, TreatmentGoalStatus status) {
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = Objects.requireNonNull(status, "El estado no puede ser nulo");
        this.updatedAt = Instant.now();
        recordEvent(new TreatmentGoalUpdatedEvent(this.id.value(), this.updatedAt));
    }

    @Override
    public TreatmentGoalId getId() {
        return id;
    }

    public TreatmentGoalName getName() {
        return name;
    }

    public TreatmentGoalStatus getStatus() {
        return status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
