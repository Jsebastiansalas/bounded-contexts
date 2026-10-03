package com.demodd.domain.clinical.encounter.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;

public class EncounterName implements ValueObject {

    private final String value;

    public EncounterName(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("El valor de EncounterName no puede estar vacio");
        }
        this.value = value.trim();
    }

    public static EncounterName of(String value) {
        return new EncounterName(value);
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EncounterName that = (EncounterName) o;
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
