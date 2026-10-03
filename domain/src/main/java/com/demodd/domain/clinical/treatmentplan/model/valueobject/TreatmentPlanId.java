package com.demodd.domain.clinical.treatmentplan.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;
import java.util.UUID;

public class TreatmentPlanId implements ValueObject {

    private final UUID value;

    public TreatmentPlanId(UUID value) {
        this.value = Objects.requireNonNull(value, "El valor de TreatmentPlanId no puede ser nulo");
    }

    public static TreatmentPlanId of(UUID value) {
        return new TreatmentPlanId(value);
    }

    public static TreatmentPlanId of(String value) {
        return new TreatmentPlanId(UUID.fromString(value));
    }

    public static TreatmentPlanId random() {
        return new TreatmentPlanId(UUID.randomUUID());
    }

    public UUID value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreatmentPlanId that = (TreatmentPlanId) o;
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
