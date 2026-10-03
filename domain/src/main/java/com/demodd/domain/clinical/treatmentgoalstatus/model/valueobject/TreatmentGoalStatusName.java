package com.demodd.domain.clinical.treatmentgoalstatus.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;

public class TreatmentGoalStatusName implements ValueObject {

    private final String value;

    public TreatmentGoalStatusName(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("El valor de TreatmentGoalStatusName no puede estar vacio");
        }
        this.value = value.trim();
    }

    public static TreatmentGoalStatusName of(String value) {
        return new TreatmentGoalStatusName(value);
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreatmentGoalStatusName that = (TreatmentGoalStatusName) o;
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
