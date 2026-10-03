package com.demodd.domain.clinical.treatmentgoalstatus.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;
import java.util.UUID;

public class TreatmentGoalStatusId implements ValueObject {

    private final UUID value;

    public TreatmentGoalStatusId(UUID value) {
        this.value = Objects.requireNonNull(value, "El valor de TreatmentGoalStatusId no puede ser nulo");
    }

    public static TreatmentGoalStatusId of(UUID value) {
        return new TreatmentGoalStatusId(value);
    }

    public static TreatmentGoalStatusId of(String value) {
        return new TreatmentGoalStatusId(UUID.fromString(value));
    }

    public static TreatmentGoalStatusId random() {
        return new TreatmentGoalStatusId(UUID.randomUUID());
    }

    public UUID value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreatmentGoalStatusId that = (TreatmentGoalStatusId) o;
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
