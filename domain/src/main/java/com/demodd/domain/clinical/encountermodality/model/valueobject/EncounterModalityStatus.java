package com.demodd.domain.clinical.encountermodality.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;

public class EncounterModalityStatus implements ValueObject {

    private final String value;

    public EncounterModalityStatus(String value) {
        this.value = value != null ? value.trim().toUpperCase() : "ACTIVE";
    }

    public static EncounterModalityStatus of(String value) {
        return new EncounterModalityStatus(value);
    }

    public static EncounterModalityStatus active() {
        return new EncounterModalityStatus("ACTIVE");
    }

    public static EncounterModalityStatus inactive() {
        return new EncounterModalityStatus("INACTIVE");
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EncounterModalityStatus that = (EncounterModalityStatus) o;
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
