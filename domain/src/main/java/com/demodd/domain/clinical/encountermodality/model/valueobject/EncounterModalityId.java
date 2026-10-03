package com.demodd.domain.clinical.encountermodality.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;
import java.util.UUID;

public class EncounterModalityId implements ValueObject {

    private final UUID value;

    public EncounterModalityId(UUID value) {
        this.value = Objects.requireNonNull(value, "El valor de EncounterModalityId no puede ser nulo");
    }

    public static EncounterModalityId of(UUID value) {
        return new EncounterModalityId(value);
    }

    public static EncounterModalityId of(String value) {
        return new EncounterModalityId(UUID.fromString(value));
    }

    public static EncounterModalityId random() {
        return new EncounterModalityId(UUID.randomUUID());
    }

    public UUID value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EncounterModalityId that = (EncounterModalityId) o;
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
