package com.demodd.domain.geography.study.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;

public class StudyStatus implements ValueObject {

    private final String value;

    public StudyStatus(String value) {
        this.value = value != null ? value.trim().toUpperCase() : "ACTIVE";
    }

    public static StudyStatus of(String value) {
        return new StudyStatus(value);
    }

    public static StudyStatus active() {
        return new StudyStatus("ACTIVE");
    }

    public static StudyStatus inactive() {
        return new StudyStatus("INACTIVE");
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudyStatus that = (StudyStatus) o;
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
