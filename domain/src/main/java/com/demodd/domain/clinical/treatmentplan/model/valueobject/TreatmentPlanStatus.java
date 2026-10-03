package com.demodd.domain.clinical.treatmentplan.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;

public class TreatmentPlanStatus implements ValueObject {

    private final String value;

    public TreatmentPlanStatus(String value) {
        this.value = value != null ? value.trim().toUpperCase() : "ACTIVE";
    }

    public static TreatmentPlanStatus of(String value) {
        return new TreatmentPlanStatus(value);
    }

    public static TreatmentPlanStatus active() {
        return new TreatmentPlanStatus("ACTIVE");
    }

    public static TreatmentPlanStatus inactive() {
        return new TreatmentPlanStatus("INACTIVE");
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreatmentPlanStatus that = (TreatmentPlanStatus) o;
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
