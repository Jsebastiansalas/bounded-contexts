package com.demodd.domain.clinical.consenttype.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;

public class ConsentTypeName implements ValueObject {

    private final String value;

    public ConsentTypeName(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("El valor de ConsentTypeName no puede estar vacio");
        }
        this.value = value.trim();
    }

    public static ConsentTypeName of(String value) {
        return new ConsentTypeName(value);
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConsentTypeName that = (ConsentTypeName) o;
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
