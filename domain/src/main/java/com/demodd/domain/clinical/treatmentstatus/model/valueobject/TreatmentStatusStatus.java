package com.demodd.domain.clinical.treatmentstatus.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;

public class TreatmentStatusStatus implements ValueObject {

    private final String value;

    public TreatmentStatusStatus(String value) {
        this.value = value != null ? value.trim().toUpperCase() : "ACTIVE";
    }

    public static TreatmentStatusStatus of(String value) {
        return new TreatmentStatusStatus(value);
    }

    public static TreatmentStatusStatus active() {
        return new TreatmentStatusStatus("ACTIVE");
    }

    public static TreatmentStatusStatus inactive() {
        return new TreatmentStatusStatus("INACTIVE");
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreatmentStatusStatus that = (TreatmentStatusStatus) o;
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
