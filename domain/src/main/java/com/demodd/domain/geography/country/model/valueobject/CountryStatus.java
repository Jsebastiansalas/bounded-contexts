package com.demodd.domain.geography.country.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;

public class CountryStatus implements ValueObject {

    private final String value;

    public CountryStatus(String value) {
        this.value = value != null ? value.trim().toUpperCase() : "ACTIVE";
    }

    public static CountryStatus of(String value) {
        return new CountryStatus(value);
    }

    public static CountryStatus active() {
        return new CountryStatus("ACTIVE");
    }

    public static CountryStatus inactive() {
        return new CountryStatus("INACTIVE");
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountryStatus that = (CountryStatus) o;
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
