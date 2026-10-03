package com.demodd.domain.clinical.treatmentstatus.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;

public class TreatmentStatusName implements ValueObject {

    private final String value;

    public TreatmentStatusName(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("El valor de TreatmentStatusName no puede estar vacio");
        }
        this.value = value.trim();
    }

    public static TreatmentStatusName of(String value) {
        return new TreatmentStatusName(value);
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreatmentStatusName that = (TreatmentStatusName) o;
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
