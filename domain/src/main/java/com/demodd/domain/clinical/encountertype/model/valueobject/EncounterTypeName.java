package com.demodd.domain.clinical.encountertype.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;

public class EncounterTypeName implements ValueObject {

    private final String value;

    public EncounterTypeName(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("El valor de EncounterTypeName no puede estar vacio");
        }
        this.value = value.trim();
    }

    public static EncounterTypeName of(String value) {
        return new EncounterTypeName(value);
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EncounterTypeName that = (EncounterTypeName) o;
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
