package com.demodd.domain.clinical.encounterstatus.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;

public class EncounterStatusName implements ValueObject {

    private final String value;

    public EncounterStatusName(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("El valor de EncounterStatusName no puede estar vacio");
        }
        this.value = value.trim();
    }

    public static EncounterStatusName of(String value) {
        return new EncounterStatusName(value);
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EncounterStatusName that = (EncounterStatusName) o;
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
