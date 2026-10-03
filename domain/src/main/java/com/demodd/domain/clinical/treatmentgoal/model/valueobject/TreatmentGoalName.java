package com.demodd.domain.clinical.treatmentgoal.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;

public class TreatmentGoalName implements ValueObject {

    private final String value;

    public TreatmentGoalName(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("El valor de TreatmentGoalName no puede estar vacio");
        }
        this.value = value.trim();
    }

    public static TreatmentGoalName of(String value) {
        return new TreatmentGoalName(value);
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreatmentGoalName that = (TreatmentGoalName) o;
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
