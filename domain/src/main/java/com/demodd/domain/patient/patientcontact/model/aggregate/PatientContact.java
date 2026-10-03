package com.demodd.domain.patient.patientcontact.model.aggregate;

import com.demodd.domain.common.AggregateRoot;
import com.demodd.domain.patient.patientcontact.event.PatientContactCreatedEvent;
import com.demodd.domain.patient.patientcontact.event.PatientContactUpdatedEvent;
import com.demodd.domain.patient.patientcontact.model.valueobject.PatientContactId;
import com.demodd.domain.patient.patientcontact.model.valueobject.PatientContactName;
import com.demodd.domain.patient.patientcontact.model.valueobject.PatientContactStatus;

import java.time.Instant;
import java.util.Objects;

public class PatientContact extends AggregateRoot<PatientContactId> {

    private final PatientContactId id;
    private PatientContactName name;
    private PatientContactStatus status;
    private final Instant createdAt;
    private Instant updatedAt;

    public PatientContact(PatientContactId id, PatientContactName name, PatientContactStatus status, Instant createdAt, Instant updatedAt) {
        this.id = Objects.requireNonNull(id, "El identificador no puede ser nulo");
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = status != null ? status : PatientContactStatus.active();
        this.createdAt = createdAt != null ? createdAt : Instant.now();
        this.updatedAt = updatedAt != null ? updatedAt : Instant.now();
    }

    public static PatientContact create(PatientContactName name) {
        PatientContactId id = PatientContactId.random();
        PatientContact entity = new PatientContact(id, name, PatientContactStatus.active(), Instant.now(), Instant.now());
        entity.recordEvent(new PatientContactCreatedEvent(id.value(), entity.getCreatedAt()));
        return entity;
    }

    public void update(PatientContactName name, PatientContactStatus status) {
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = Objects.requireNonNull(status, "El estado no puede ser nulo");
        this.updatedAt = Instant.now();
        recordEvent(new PatientContactUpdatedEvent(this.id.value(), this.updatedAt));
    }

    @Override
    public PatientContactId getId() {
        return id;
    }

    public PatientContactName getName() {
        return name;
    }

    public PatientContactStatus getStatus() {
        return status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
