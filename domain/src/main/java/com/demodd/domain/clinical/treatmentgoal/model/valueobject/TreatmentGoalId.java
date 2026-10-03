package com.demodd.domain.clinical.treatmentgoal.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;
import java.util.UUID;

public class TreatmentGoalId implements ValueObject {

    private final UUID value;

    public TreatmentGoalId(UUID value) {
        this.value = Objects.requireNonNull(value, "El valor de TreatmentGoalId no puede ser nulo");
    }

    public static TreatmentGoalId of(UUID value) {
        return new TreatmentGoalId(value);
    }

    public static TreatmentGoalId of(String value) {
        return new TreatmentGoalId(UUID.fromString(value));
    }

    public static TreatmentGoalId random() {
        return new TreatmentGoalId(UUID.randomUUID());
    }

    public UUID value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreatmentGoalId that = (TreatmentGoalId) o;
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
