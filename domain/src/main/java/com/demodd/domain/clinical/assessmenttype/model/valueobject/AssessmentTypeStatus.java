package com.demodd.domain.clinical.assessmenttype.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;

public class AssessmentTypeStatus implements ValueObject {

    private final String value;

    public AssessmentTypeStatus(String value) {
        this.value = value != null ? value.trim().toUpperCase() : "ACTIVE";
    }

    public static AssessmentTypeStatus of(String value) {
        return new AssessmentTypeStatus(value);
    }

    public static AssessmentTypeStatus active() {
        return new AssessmentTypeStatus("ACTIVE");
    }

    public static AssessmentTypeStatus inactive() {
        return new AssessmentTypeStatus("INACTIVE");
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AssessmentTypeStatus that = (AssessmentTypeStatus) o;
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
