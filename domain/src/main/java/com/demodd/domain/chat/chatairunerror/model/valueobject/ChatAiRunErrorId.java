package com.demodd.domain.chat.chatairunerror.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;
import java.util.UUID;

public class ChatAiRunErrorId implements ValueObject {

    private final UUID value;

    public ChatAiRunErrorId(UUID value) {
        this.value = Objects.requireNonNull(value, "El valor de ChatAiRunErrorId no puede ser nulo");
    }

    public static ChatAiRunErrorId of(UUID value) {
        return new ChatAiRunErrorId(value);
    }

    public static ChatAiRunErrorId of(String value) {
        return new ChatAiRunErrorId(UUID.fromString(value));
    }

    public static ChatAiRunErrorId random() {
        return new ChatAiRunErrorId(UUID.randomUUID());
    }

    public UUID value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatAiRunErrorId that = (ChatAiRunErrorId) o;
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
