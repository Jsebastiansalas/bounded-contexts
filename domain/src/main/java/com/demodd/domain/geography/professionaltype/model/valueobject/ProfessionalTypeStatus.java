package com.demodd.domain.geography.professionaltype.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;

public class ProfessionalTypeStatus implements ValueObject {

    private final String value;

    public ProfessionalTypeStatus(String value) {
        this.value = value != null ? value.trim().toUpperCase() : "ACTIVE";
    }

    public static ProfessionalTypeStatus of(String value) {
        return new ProfessionalTypeStatus(value);
    }

    public static ProfessionalTypeStatus active() {
        return new ProfessionalTypeStatus("ACTIVE");
    }

    public static ProfessionalTypeStatus inactive() {
        return new ProfessionalTypeStatus("INACTIVE");
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfessionalTypeStatus that = (ProfessionalTypeStatus) o;
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
