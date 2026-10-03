package com.demodd.domain.clinical.treatmentplan.model.aggregate;

import com.demodd.domain.common.AggregateRoot;
import com.demodd.domain.clinical.treatmentplan.event.TreatmentPlanCreatedEvent;
import com.demodd.domain.clinical.treatmentplan.event.TreatmentPlanUpdatedEvent;
import com.demodd.domain.clinical.treatmentplan.model.valueobject.TreatmentPlanId;
import com.demodd.domain.clinical.treatmentplan.model.valueobject.TreatmentPlanName;
import com.demodd.domain.clinical.treatmentplan.model.valueobject.TreatmentPlanStatus;

import java.time.Instant;
import java.util.Objects;

public class TreatmentPlan extends AggregateRoot<TreatmentPlanId> {

    private final TreatmentPlanId id;
    private TreatmentPlanName name;
    private TreatmentPlanStatus status;
    private final Instant createdAt;
    private Instant updatedAt;

    public TreatmentPlan(TreatmentPlanId id, TreatmentPlanName name, TreatmentPlanStatus status, Instant createdAt, Instant updatedAt) {
        this.id = Objects.requireNonNull(id, "El identificador no puede ser nulo");
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = status != null ? status : TreatmentPlanStatus.active();
        this.createdAt = createdAt != null ? createdAt : Instant.now();
        this.updatedAt = updatedAt != null ? updatedAt : Instant.now();
    }

    public static TreatmentPlan create(TreatmentPlanName name) {
        TreatmentPlanId id = TreatmentPlanId.random();
        TreatmentPlan entity = new TreatmentPlan(id, name, TreatmentPlanStatus.active(), Instant.now(), Instant.now());
        entity.recordEvent(new TreatmentPlanCreatedEvent(id.value(), entity.getCreatedAt()));
        return entity;
    }

    public void update(TreatmentPlanName name, TreatmentPlanStatus status) {
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = Objects.requireNonNull(status, "El estado no puede ser nulo");
        this.updatedAt = Instant.now();
        recordEvent(new TreatmentPlanUpdatedEvent(this.id.value(), this.updatedAt));
    }

    @Override
    public TreatmentPlanId getId() {
        return id;
    }

    public TreatmentPlanName getName() {
        return name;
    }

    public TreatmentPlanStatus getStatus() {
        return status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
