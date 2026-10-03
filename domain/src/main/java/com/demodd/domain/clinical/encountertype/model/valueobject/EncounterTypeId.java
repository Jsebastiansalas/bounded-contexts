package com.demodd.domain.clinical.encountertype.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;
import java.util.UUID;

public class EncounterTypeId implements ValueObject {

    private final UUID value;

    public EncounterTypeId(UUID value) {
        this.value = Objects.requireNonNull(value, "El valor de EncounterTypeId no puede ser nulo");
    }

    public static EncounterTypeId of(UUID value) {
        return new EncounterTypeId(value);
    }

    public static EncounterTypeId of(String value) {
        return new EncounterTypeId(UUID.fromString(value));
    }

    public static EncounterTypeId random() {
        return new EncounterTypeId(UUID.randomUUID());
    }

    public UUID value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EncounterTypeId that = (EncounterTypeId) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
