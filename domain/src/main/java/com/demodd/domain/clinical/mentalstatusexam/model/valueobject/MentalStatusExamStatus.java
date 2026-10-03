package com.demodd.domain.clinical.mentalstatusexam.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;

public class MentalStatusExamStatus implements ValueObject {

    private final String value;

    public MentalStatusExamStatus(String value) {
        this.value = value != null ? value.trim().toUpperCase() : "ACTIVE";
    }

    public static MentalStatusExamStatus of(String value) {
        return new MentalStatusExamStatus(value);
    }

    public static MentalStatusExamStatus active() {
        return new MentalStatusExamStatus("ACTIVE");
    }

    public static MentalStatusExamStatus inactive() {
        return new MentalStatusExamStatus("INACTIVE");
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MentalStatusExamStatus that = (MentalStatusExamStatus) o;
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
