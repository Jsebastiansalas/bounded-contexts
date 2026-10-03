package com.demodd.domain.geography.country.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;

public class CountryName implements ValueObject {

    private final String value;

    public CountryName(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("El valor de CountryName no puede estar vacio");
        }
        this.value = value.trim();
    }

    public static CountryName of(String value) {
        return new CountryName(value);
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountryName that = (CountryName) o;
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
