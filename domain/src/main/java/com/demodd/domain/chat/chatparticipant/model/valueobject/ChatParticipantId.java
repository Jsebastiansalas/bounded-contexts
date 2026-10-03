package com.demodd.domain.chat.chatparticipant.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;
import java.util.UUID;

public class ChatParticipantId implements ValueObject {

    private final UUID value;

    public ChatParticipantId(UUID value) {
        this.value = Objects.requireNonNull(value, "El valor de ChatParticipantId no puede ser nulo");
    }

    public static ChatParticipantId of(UUID value) {
        return new ChatParticipantId(value);
    }

    public static ChatParticipantId of(String value) {
        return new ChatParticipantId(UUID.fromString(value));
    }

    public static ChatParticipantId random() {
        return new ChatParticipantId(UUID.randomUUID());
    }

    public UUID value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatParticipantId that = (ChatParticipantId) o;
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
