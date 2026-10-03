package com.demodd.domain.clinical.treatmentstatus.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;
import java.util.UUID;

public class TreatmentStatusId implements ValueObject {

    private final UUID value;

    public TreatmentStatusId(UUID value) {
        this.value = Objects.requireNonNull(value, "El valor de TreatmentStatusId no puede ser nulo");
    }

    public static TreatmentStatusId of(UUID value) {
        return new TreatmentStatusId(value);
    }

    public static TreatmentStatusId of(String value) {
        return new TreatmentStatusId(UUID.fromString(value));
    }

    public static TreatmentStatusId random() {
        return new TreatmentStatusId(UUID.randomUUID());
    }

    public UUID value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreatmentStatusId that = (TreatmentStatusId) o;
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
