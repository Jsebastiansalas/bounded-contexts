package com.demodd.domain.patient.professionalstudy.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;

public class ProfessionalStudyStatus implements ValueObject {

    private final String value;

    public ProfessionalStudyStatus(String value) {
        this.value = value != null ? value.trim().toUpperCase() : "ACTIVE";
    }

    public static ProfessionalStudyStatus of(String value) {
        return new ProfessionalStudyStatus(value);
    }

    public static ProfessionalStudyStatus active() {
        return new ProfessionalStudyStatus("ACTIVE");
    }

    public static ProfessionalStudyStatus inactive() {
        return new ProfessionalStudyStatus("INACTIVE");
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfessionalStudyStatus that = (ProfessionalStudyStatus) o;
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
