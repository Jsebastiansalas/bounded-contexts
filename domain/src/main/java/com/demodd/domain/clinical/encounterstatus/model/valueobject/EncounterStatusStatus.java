package com.demodd.domain.clinical.encounterstatus.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;

public class EncounterStatusStatus implements ValueObject {

    private final String value;

    public EncounterStatusStatus(String value) {
        this.value = value != null ? value.trim().toUpperCase() : "ACTIVE";
    }

    public static EncounterStatusStatus of(String value) {
        return new EncounterStatusStatus(value);
    }

    public static EncounterStatusStatus active() {
        return new EncounterStatusStatus("ACTIVE");
    }

    public static EncounterStatusStatus inactive() {
        return new EncounterStatusStatus("INACTIVE");
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EncounterStatusStatus that = (EncounterStatusStatus) o;
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
