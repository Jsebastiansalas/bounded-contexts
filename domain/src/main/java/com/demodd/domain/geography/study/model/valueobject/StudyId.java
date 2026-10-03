package com.demodd.domain.geography.study.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;
import java.util.UUID;

public class StudyId implements ValueObject {

    private final UUID value;

    public StudyId(UUID value) {
        this.value = Objects.requireNonNull(value, "El valor de StudyId no puede ser nulo");
    }

    public static StudyId of(UUID value) {
        return new StudyId(value);
    }

    public static StudyId of(String value) {
        return new StudyId(UUID.fromString(value));
    }

    public static StudyId random() {
        return new StudyId(UUID.randomUUID());
    }

    public UUID value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudyId that = (StudyId) o;
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
