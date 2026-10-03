package com.demodd.domain.chat.chatescalationstatushistory.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;
import java.util.UUID;

public class ChatEscalationStatusHistoryId implements ValueObject {

    private final UUID value;

    public ChatEscalationStatusHistoryId(UUID value) {
        this.value = Objects.requireNonNull(value, "El valor de ChatEscalationStatusHistoryId no puede ser nulo");
    }

    public static ChatEscalationStatusHistoryId of(UUID value) {
        return new ChatEscalationStatusHistoryId(value);
    }

    public static ChatEscalationStatusHistoryId of(String value) {
        return new ChatEscalationStatusHistoryId(UUID.fromString(value));
    }

    public static ChatEscalationStatusHistoryId random() {
        return new ChatEscalationStatusHistoryId(UUID.randomUUID());
    }

    public UUID value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatEscalationStatusHistoryId that = (ChatEscalationStatusHistoryId) o;
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
