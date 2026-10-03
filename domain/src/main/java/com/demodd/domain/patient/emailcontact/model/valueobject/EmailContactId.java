package com.demodd.domain.patient.emailcontact.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;
import java.util.UUID;

public class EmailContactId implements ValueObject {

    private final UUID value;

    public EmailContactId(UUID value) {
        this.value = Objects.requireNonNull(value, "El valor de EmailContactId no puede ser nulo");
    }

    public static EmailContactId of(UUID value) {
        return new EmailContactId(value);
    }

    public static EmailContactId of(String value) {
        return new EmailContactId(UUID.fromString(value));
    }

    public static EmailContactId random() {
        return new EmailContactId(UUID.randomUUID());
    }

    public UUID value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmailContactId that = (EmailContactId) o;
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
