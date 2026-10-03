package com.demodd.domain.patient.contact.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;
import java.util.UUID;

public class ContactId implements ValueObject {

    private final UUID value;

    public ContactId(UUID value) {
        this.value = Objects.requireNonNull(value, "El valor de ContactId no puede ser nulo");
    }

    public static ContactId of(UUID value) {
        return new ContactId(value);
    }

    public static ContactId of(String value) {
        return new ContactId(UUID.fromString(value));
    }

    public static ContactId random() {
        return new ContactId(UUID.randomUUID());
    }

    public UUID value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactId that = (ContactId) o;
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
