package com.demodd.domain.clinical.riskassessment.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;

public class RiskAssessmentName implements ValueObject {

    private final String value;

    public RiskAssessmentName(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("El valor de RiskAssessmentName no puede estar vacio");
        }
        this.value = value.trim();
    }

    public static RiskAssessmentName of(String value) {
        return new RiskAssessmentName(value);
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RiskAssessmentName that = (RiskAssessmentName) o;
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
