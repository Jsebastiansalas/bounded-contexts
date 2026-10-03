package com.demodd.domain.patient.patientcontact.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;
import java.util.UUID;

public class PatientContactId implements ValueObject {

    private final UUID value;

    public PatientContactId(UUID value) {
        this.value = Objects.requireNonNull(value, "El valor de PatientContactId no puede ser nulo");
    }

    public static PatientContactId of(UUID value) {
        return new PatientContactId(value);
    }

    public static PatientContactId of(String value) {
        return new PatientContactId(UUID.fromString(value));
    }

    public static PatientContactId random() {
        return new PatientContactId(UUID.randomUUID());
    }

    public UUID value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatientContactId that = (PatientContactId) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
