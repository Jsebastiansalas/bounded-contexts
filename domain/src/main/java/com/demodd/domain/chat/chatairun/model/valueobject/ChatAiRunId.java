package com.demodd.domain.chat.chatairun.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;
import java.util.UUID;

public class ChatAiRunId implements ValueObject {

    private final UUID value;

    public ChatAiRunId(UUID value) {
        this.value = Objects.requireNonNull(value, "El valor de ChatAiRunId no puede ser nulo");
    }

    public static ChatAiRunId of(UUID value) {
        return new ChatAiRunId(value);
    }

    public static ChatAiRunId of(String value) {
        return new ChatAiRunId(UUID.fromString(value));
    }

    public static ChatAiRunId random() {
        return new ChatAiRunId(UUID.randomUUID());
    }

    public UUID value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatAiRunId that = (ChatAiRunId) o;
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
