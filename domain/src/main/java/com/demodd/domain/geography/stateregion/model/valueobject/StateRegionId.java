package com.demodd.domain.geography.stateregion.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;
import java.util.UUID;

public class StateRegionId implements ValueObject {

    private final UUID value;

    public StateRegionId(UUID value) {
        this.value = Objects.requireNonNull(value, "El valor de StateRegionId no puede ser nulo");
    }

    public static StateRegionId of(UUID value) {
        return new StateRegionId(value);
    }

    public static StateRegionId of(String value) {
        return new StateRegionId(UUID.fromString(value));
    }

    public static StateRegionId random() {
        return new StateRegionId(UUID.randomUUID());
    }

    public UUID value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StateRegionId that = (StateRegionId) o;
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
