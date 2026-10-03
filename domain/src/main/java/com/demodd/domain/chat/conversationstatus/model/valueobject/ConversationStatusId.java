package com.demodd.domain.chat.conversationstatus.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;
import java.util.UUID;

public class ConversationStatusId implements ValueObject {

    private final UUID value;

    public ConversationStatusId(UUID value) {
        this.value = Objects.requireNonNull(value, "El valor de ConversationStatusId no puede ser nulo");
    }

    public static ConversationStatusId of(UUID value) {
        return new ConversationStatusId(value);
    }

    public static ConversationStatusId of(String value) {
        return new ConversationStatusId(UUID.fromString(value));
    }

    public static ConversationStatusId random() {
        return new ConversationStatusId(UUID.randomUUID());
    }

    public UUID value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConversationStatusId that = (ConversationStatusId) o;
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
