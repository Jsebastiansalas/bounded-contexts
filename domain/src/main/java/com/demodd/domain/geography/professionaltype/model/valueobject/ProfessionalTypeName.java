package com.demodd.domain.geography.professionaltype.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;

public class ProfessionalTypeName implements ValueObject {

    private final String value;

    public ProfessionalTypeName(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("El valor de ProfessionalTypeName no puede estar vacio");
        }
        this.value = value.trim();
    }

    public static ProfessionalTypeName of(String value) {
        return new ProfessionalTypeName(value);
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfessionalTypeName that = (ProfessionalTypeName) o;
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
