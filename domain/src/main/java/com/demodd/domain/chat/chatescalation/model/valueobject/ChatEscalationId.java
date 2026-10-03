package com.demodd.domain.chat.chatescalation.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;
import java.util.UUID;

public class ChatEscalationId implements ValueObject {

    private final UUID value;

    public ChatEscalationId(UUID value) {
        this.value = Objects.requireNonNull(value, "El valor de ChatEscalationId no puede ser nulo");
    }

    public static ChatEscalationId of(UUID value) {
        return new ChatEscalationId(value);
    }

    public static ChatEscalationId of(String value) {
        return new ChatEscalationId(UUID.fromString(value));
    }

    public static ChatEscalationId random() {
        return new ChatEscalationId(UUID.randomUUID());
    }

    public UUID value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatEscalationId that = (ChatEscalationId) o;
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
