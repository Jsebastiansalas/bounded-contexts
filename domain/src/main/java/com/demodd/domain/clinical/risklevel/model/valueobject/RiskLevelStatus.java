package com.demodd.domain.clinical.risklevel.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;

public class RiskLevelStatus implements ValueObject {

    private final String value;

    public RiskLevelStatus(String value) {
        this.value = value != null ? value.trim().toUpperCase() : "ACTIVE";
    }

    public static RiskLevelStatus of(String value) {
        return new RiskLevelStatus(value);
    }

    public static RiskLevelStatus active() {
        return new RiskLevelStatus("ACTIVE");
    }

    public static RiskLevelStatus inactive() {
        return new RiskLevelStatus("INACTIVE");
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RiskLevelStatus that = (RiskLevelStatus) o;
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
