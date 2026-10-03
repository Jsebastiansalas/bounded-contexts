package com.demodd.domain.chat.chatescalationassignment.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;
import java.util.UUID;

public class ChatEscalationAssignmentId implements ValueObject {

    private final UUID value;

    public ChatEscalationAssignmentId(UUID value) {
        this.value = Objects.requireNonNull(value, "El valor de ChatEscalationAssignmentId no puede ser nulo");
    }

    public static ChatEscalationAssignmentId of(UUID value) {
        return new ChatEscalationAssignmentId(value);
    }

    public static ChatEscalationAssignmentId of(String value) {
        return new ChatEscalationAssignmentId(UUID.fromString(value));
    }

    public static ChatEscalationAssignmentId random() {
        return new ChatEscalationAssignmentId(UUID.randomUUID());
    }

    public UUID value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatEscalationAssignmentId that = (ChatEscalationAssignmentId) o;
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
