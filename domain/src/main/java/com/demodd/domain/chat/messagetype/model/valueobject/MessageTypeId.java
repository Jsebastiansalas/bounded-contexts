package com.demodd.domain.chat.messagetype.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;
import java.util.UUID;

public class MessageTypeId implements ValueObject {

    private final UUID value;

    public MessageTypeId(UUID value) {
        this.value = Objects.requireNonNull(value, "El valor de MessageTypeId no puede ser nulo");
    }

    public static MessageTypeId of(UUID value) {
        return new MessageTypeId(value);
    }

    public static MessageTypeId of(String value) {
        return new MessageTypeId(UUID.fromString(value));
    }

    public static MessageTypeId random() {
        return new MessageTypeId(UUID.randomUUID());
    }

    public UUID value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageTypeId that = (MessageTypeId) o;
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
