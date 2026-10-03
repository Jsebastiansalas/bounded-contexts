package com.demodd.domain.clinical.encounterstatus.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;
import java.util.UUID;

public class EncounterStatusId implements ValueObject {

    private final UUID value;

    public EncounterStatusId(UUID value) {
        this.value = Objects.requireNonNull(value, "El valor de EncounterStatusId no puede ser nulo");
    }

    public static EncounterStatusId of(UUID value) {
        return new EncounterStatusId(value);
    }

    public static EncounterStatusId of(String value) {
        return new EncounterStatusId(UUID.fromString(value));
    }

    public static EncounterStatusId random() {
        return new EncounterStatusId(UUID.randomUUID());
    }

    public UUID value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EncounterStatusId that = (EncounterStatusId) o;
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
