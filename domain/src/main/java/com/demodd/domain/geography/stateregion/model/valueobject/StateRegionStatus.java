package com.demodd.domain.geography.stateregion.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;

public class StateRegionStatus implements ValueObject {

    private final String value;

    public StateRegionStatus(String value) {
        this.value = value != null ? value.trim().toUpperCase() : "ACTIVE";
    }

    public static StateRegionStatus of(String value) {
        return new StateRegionStatus(value);
    }

    public static StateRegionStatus active() {
        return new StateRegionStatus("ACTIVE");
    }

    public static StateRegionStatus inactive() {
        return new StateRegionStatus("INACTIVE");
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StateRegionStatus that = (StateRegionStatus) o;
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
