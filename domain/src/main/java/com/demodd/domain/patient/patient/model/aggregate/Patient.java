package com.demodd.domain.patient.patient.model.aggregate;

import com.demodd.domain.common.AggregateRoot;
import com.demodd.domain.patient.patient.event.PatientCreatedEvent;
import com.demodd.domain.patient.patient.event.PatientUpdatedEvent;
import com.demodd.domain.patient.patient.model.valueobject.PatientId;
import com.demodd.domain.patient.patient.model.valueobject.PatientName;
import com.demodd.domain.patient.patient.model.valueobject.PatientStatus;

import java.time.Instant;
import java.util.Objects;

public class Patient extends AggregateRoot<PatientId> {

    private final PatientId id;
    private PatientName name;
    private PatientStatus status;
    private final Instant createdAt;
    private Instant updatedAt;

    public Patient(PatientId id, PatientName name, PatientStatus status, Instant createdAt, Instant updatedAt) {
        this.id = Objects.requireNonNull(id, "El identificador no puede ser nulo");
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = status != null ? status : PatientStatus.active();
        this.createdAt = createdAt != null ? createdAt : Instant.now();
        this.updatedAt = updatedAt != null ? updatedAt : Instant.now();
    }

    public static Patient create(PatientName name) {
        PatientId id = PatientId.random();
        Patient entity = new Patient(id, name, PatientStatus.active(), Instant.now(), Instant.now());
        entity.recordEvent(new PatientCreatedEvent(id.value(), entity.getCreatedAt()));
        return entity;
    }

    public void update(PatientName name, PatientStatus status) {
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = Objects.requireNonNull(status, "El estado no puede ser nulo");
        this.updatedAt = Instant.now();
        recordEvent(new PatientUpdatedEvent(this.id.value(), this.updatedAt));
    }

    @Override
    public PatientId getId() {
        return id;
    }

    public PatientName getName() {
        return name;
    }

    public PatientStatus getStatus() {
        return status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
