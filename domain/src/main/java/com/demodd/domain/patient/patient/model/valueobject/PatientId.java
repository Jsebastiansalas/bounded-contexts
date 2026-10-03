package com.demodd.domain.patient.patient.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;
import java.util.UUID;

public class PatientId implements ValueObject {

    private final UUID value;

    public PatientId(UUID value) {
        this.value = Objects.requireNonNull(value, "El valor de PatientId no puede ser nulo");
    }

    public static PatientId of(UUID value) {
        return new PatientId(value);
    }

    public static PatientId of(String value) {
        return new PatientId(UUID.fromString(value));
    }

    public static PatientId random() {
        return new PatientId(UUID.randomUUID());
    }

    public UUID value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatientId that = (PatientId) o;
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
