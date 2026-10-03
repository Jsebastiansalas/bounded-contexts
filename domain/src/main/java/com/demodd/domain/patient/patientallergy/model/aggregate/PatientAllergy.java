package com.demodd.domain.patient.patientallergy.model.aggregate;

import com.demodd.domain.common.AggregateRoot;
import com.demodd.domain.patient.patientallergy.event.PatientAllergyCreatedEvent;
import com.demodd.domain.patient.patientallergy.event.PatientAllergyUpdatedEvent;
import com.demodd.domain.patient.patientallergy.model.valueobject.PatientAllergyId;
import com.demodd.domain.patient.patientallergy.model.valueobject.PatientAllergyName;
import com.demodd.domain.patient.patientallergy.model.valueobject.PatientAllergyStatus;

import java.time.Instant;
import java.util.Objects;

public class PatientAllergy extends AggregateRoot<PatientAllergyId> {

    private final PatientAllergyId id;
    private PatientAllergyName name;
    private PatientAllergyStatus status;
    private final Instant createdAt;
    private Instant updatedAt;

    public PatientAllergy(PatientAllergyId id, PatientAllergyName name, PatientAllergyStatus status, Instant createdAt, Instant updatedAt) {
        this.id = Objects.requireNonNull(id, "El identificador no puede ser nulo");
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = status != null ? status : PatientAllergyStatus.active();
        this.createdAt = createdAt != null ? createdAt : Instant.now();
        this.updatedAt = updatedAt != null ? updatedAt : Instant.now();
    }

    public static PatientAllergy create(PatientAllergyName name) {
        PatientAllergyId id = PatientAllergyId.random();
        PatientAllergy entity = new PatientAllergy(id, name, PatientAllergyStatus.active(), Instant.now(), Instant.now());
        entity.recordEvent(new PatientAllergyCreatedEvent(id.value(), entity.getCreatedAt()));
        return entity;
    }

    public void update(PatientAllergyName name, PatientAllergyStatus status) {
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = Objects.requireNonNull(status, "El estado no puede ser nulo");
        this.updatedAt = Instant.now();
        recordEvent(new PatientAllergyUpdatedEvent(this.id.value(), this.updatedAt));
    }

    @Override
    public PatientAllergyId getId() {
        return id;
    }

    public PatientAllergyName getName() {
        return name;
    }

    public PatientAllergyStatus getStatus() {
        return status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
