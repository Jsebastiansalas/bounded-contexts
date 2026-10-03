package com.demodd.domain.clinical.encountertype.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;

public class EncounterTypeStatus implements ValueObject {

    private final String value;

    public EncounterTypeStatus(String value) {
        this.value = value != null ? value.trim().toUpperCase() : "ACTIVE";
    }

    public static EncounterTypeStatus of(String value) {
        return new EncounterTypeStatus(value);
    }

    public static EncounterTypeStatus active() {
        return new EncounterTypeStatus("ACTIVE");
    }

    public static EncounterTypeStatus inactive() {
        return new EncounterTypeStatus("INACTIVE");
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EncounterTypeStatus that = (EncounterTypeStatus) o;
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
