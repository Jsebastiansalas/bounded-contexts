package com.demodd.domain.geography.stateregion.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;

public class StateRegionName implements ValueObject {

    private final String value;

    public StateRegionName(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("El valor de StateRegionName no puede estar vacio");
        }
        this.value = value.trim();
    }

    public static StateRegionName of(String value) {
        return new StateRegionName(value);
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StateRegionName that = (StateRegionName) o;
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
