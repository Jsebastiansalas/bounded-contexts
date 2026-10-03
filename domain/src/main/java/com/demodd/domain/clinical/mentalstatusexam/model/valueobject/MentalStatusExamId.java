package com.demodd.domain.clinical.mentalstatusexam.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;
import java.util.UUID;

public class MentalStatusExamId implements ValueObject {

    private final UUID value;

    public MentalStatusExamId(UUID value) {
        this.value = Objects.requireNonNull(value, "El valor de MentalStatusExamId no puede ser nulo");
    }

    public static MentalStatusExamId of(UUID value) {
        return new MentalStatusExamId(value);
    }

    public static MentalStatusExamId of(String value) {
        return new MentalStatusExamId(UUID.fromString(value));
    }

    public static MentalStatusExamId random() {
        return new MentalStatusExamId(UUID.randomUUID());
    }

    public UUID value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MentalStatusExamId that = (MentalStatusExamId) o;
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
