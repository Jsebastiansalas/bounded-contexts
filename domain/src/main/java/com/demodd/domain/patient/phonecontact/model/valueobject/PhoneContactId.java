package com.demodd.domain.patient.phonecontact.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;
import java.util.UUID;

public class PhoneContactId implements ValueObject {

    private final UUID value;

    public PhoneContactId(UUID value) {
        this.value = Objects.requireNonNull(value, "El valor de PhoneContactId no puede ser nulo");
    }

    public static PhoneContactId of(UUID value) {
        return new PhoneContactId(value);
    }

    public static PhoneContactId of(String value) {
        return new PhoneContactId(UUID.fromString(value));
    }

    public static PhoneContactId random() {
        return new PhoneContactId(UUID.randomUUID());
    }

    public UUID value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneContactId that = (PhoneContactId) o;
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
