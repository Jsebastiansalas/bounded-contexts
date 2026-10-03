package com.demodd.domain.clinical.riskassessment.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;
import java.util.UUID;

public class RiskAssessmentId implements ValueObject {

    private final UUID value;

    public RiskAssessmentId(UUID value) {
        this.value = Objects.requireNonNull(value, "El valor de RiskAssessmentId no puede ser nulo");
    }

    public static RiskAssessmentId of(UUID value) {
        return new RiskAssessmentId(value);
    }

    public static RiskAssessmentId of(String value) {
        return new RiskAssessmentId(UUID.fromString(value));
    }

    public static RiskAssessmentId random() {
        return new RiskAssessmentId(UUID.randomUUID());
    }

    public UUID value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RiskAssessmentId that = (RiskAssessmentId) o;
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
