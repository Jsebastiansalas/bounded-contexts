package com.demodd.domain.clinical.encountermodality.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;

public class EncounterModalityName implements ValueObject {

    private final String value;

    public EncounterModalityName(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("El valor de EncounterModalityName no puede estar vacio");
        }
        this.value = value.trim();
    }

    public static EncounterModalityName of(String value) {
        return new EncounterModalityName(value);
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EncounterModalityName that = (EncounterModalityName) o;
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
