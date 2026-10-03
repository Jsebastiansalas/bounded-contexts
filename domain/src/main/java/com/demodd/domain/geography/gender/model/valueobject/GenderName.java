package com.demodd.domain.geography.gender.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;

public class GenderName implements ValueObject {

    private final String value;

    public GenderName(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("El valor de GenderName no puede estar vacio");
        }
        this.value = value.trim();
    }

    public static GenderName of(String value) {
        return new GenderName(value);
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenderName that = (GenderName) o;
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
