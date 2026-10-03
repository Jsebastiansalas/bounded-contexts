package com.demodd.domain.clinical.medicationroute.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;

public class MedicationRouteName implements ValueObject {

    private final String value;

    public MedicationRouteName(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("El valor de MedicationRouteName no puede estar vacio");
        }
        this.value = value.trim();
    }

    public static MedicationRouteName of(String value) {
        return new MedicationRouteName(value);
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedicationRouteName that = (MedicationRouteName) o;
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
