package com.demodd.domain.clinical.medicationroute.model.aggregate;

import com.demodd.domain.common.AggregateRoot;
import com.demodd.domain.clinical.medicationroute.event.MedicationRouteCreatedEvent;
import com.demodd.domain.clinical.medicationroute.event.MedicationRouteUpdatedEvent;
import com.demodd.domain.clinical.medicationroute.model.valueobject.MedicationRouteId;
import com.demodd.domain.clinical.medicationroute.model.valueobject.MedicationRouteName;
import com.demodd.domain.clinical.medicationroute.model.valueobject.MedicationRouteStatus;

import java.time.Instant;
import java.util.Objects;

public class MedicationRoute extends AggregateRoot<MedicationRouteId> {

    private final MedicationRouteId id;
    private MedicationRouteName name;
    private MedicationRouteStatus status;
    private final Instant createdAt;
    private Instant updatedAt;

    public MedicationRoute(MedicationRouteId id, MedicationRouteName name, MedicationRouteStatus status, Instant createdAt, Instant updatedAt) {
        this.id = Objects.requireNonNull(id, "El identificador no puede ser nulo");
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = status != null ? status : MedicationRouteStatus.active();
        this.createdAt = createdAt != null ? createdAt : Instant.now();
        this.updatedAt = updatedAt != null ? updatedAt : Instant.now();
    }

    public static MedicationRoute create(MedicationRouteName name) {
        MedicationRouteId id = MedicationRouteId.random();
        MedicationRoute entity = new MedicationRoute(id, name, MedicationRouteStatus.active(), Instant.now(), Instant.now());
        entity.recordEvent(new MedicationRouteCreatedEvent(id.value(), entity.getCreatedAt()));
        return entity;
    }

    public void update(MedicationRouteName name, MedicationRouteStatus status) {
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = Objects.requireNonNull(status, "El estado no puede ser nulo");
        this.updatedAt = Instant.now();
        recordEvent(new MedicationRouteUpdatedEvent(this.id.value(), this.updatedAt));
    }

    @Override
    public MedicationRouteId getId() {
        return id;
    }

    public MedicationRouteName getName() {
        return name;
    }

    public MedicationRouteStatus getStatus() {
        return status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
