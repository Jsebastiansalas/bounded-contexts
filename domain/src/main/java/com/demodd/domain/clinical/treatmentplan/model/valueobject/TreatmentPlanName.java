package com.demodd.domain.clinical.treatmentplan.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;

public class TreatmentPlanName implements ValueObject {

    private final String value;

    public TreatmentPlanName(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("El valor de TreatmentPlanName no puede estar vacio");
        }
        this.value = value.trim();
    }

    public static TreatmentPlanName of(String value) {
        return new TreatmentPlanName(value);
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreatmentPlanName that = (TreatmentPlanName) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value;
    }
}
