package com.demodd.domain.patient.patient.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;

public class PatientName implements ValueObject {

    private final String value;

    public PatientName(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("El valor de PatientName no puede estar vacio");
        }
        this.value = value.trim();
    }

    public static PatientName of(String value) {
        return new PatientName(value);
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatientName that = (PatientName) o;
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
