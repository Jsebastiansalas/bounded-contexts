package com.demodd.domain.patient.professional.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;

public class ProfessionalName implements ValueObject {

    private final String value;

    public ProfessionalName(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("El valor de ProfessionalName no puede estar vacio");
        }
        this.value = value.trim();
    }

    public static ProfessionalName of(String value) {
        return new ProfessionalName(value);
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfessionalName that = (ProfessionalName) o;
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
