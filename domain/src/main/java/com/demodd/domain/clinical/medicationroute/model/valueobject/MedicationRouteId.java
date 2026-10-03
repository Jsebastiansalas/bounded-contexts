package com.demodd.domain.clinical.medicationroute.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;
import java.util.UUID;

public class MedicationRouteId implements ValueObject {

    private final UUID value;

    public MedicationRouteId(UUID value) {
        this.value = Objects.requireNonNull(value, "El valor de MedicationRouteId no puede ser nulo");
    }

    public static MedicationRouteId of(UUID value) {
        return new MedicationRouteId(value);
    }

    public static MedicationRouteId of(String value) {
        return new MedicationRouteId(UUID.fromString(value));
    }

    public static MedicationRouteId random() {
        return new MedicationRouteId(UUID.randomUUID());
    }

    public UUID value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedicationRouteId that = (MedicationRouteId) o;
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
