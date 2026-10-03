package com.demodd.domain.chat.sendertype.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;
import java.util.UUID;

public class SenderTypeId implements ValueObject {

    private final UUID value;

    public SenderTypeId(UUID value) {
        this.value = Objects.requireNonNull(value, "El valor de SenderTypeId no puede ser nulo");
    }

    public static SenderTypeId of(UUID value) {
        return new SenderTypeId(value);
    }

    public static SenderTypeId of(String value) {
        return new SenderTypeId(UUID.fromString(value));
    }

    public static SenderTypeId random() {
        return new SenderTypeId(UUID.randomUUID());
    }

    public UUID value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SenderTypeId that = (SenderTypeId) o;
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
