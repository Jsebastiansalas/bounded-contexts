package com.demodd.domain.chat.chatmessage.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;
import java.util.UUID;

public class ChatMessageId implements ValueObject {

    private final UUID value;

    public ChatMessageId(UUID value) {
        this.value = Objects.requireNonNull(value, "El valor de ChatMessageId no puede ser nulo");
    }

    public static ChatMessageId of(UUID value) {
        return new ChatMessageId(value);
    }

    public static ChatMessageId of(String value) {
        return new ChatMessageId(UUID.fromString(value));
    }

    public static ChatMessageId random() {
        return new ChatMessageId(UUID.randomUUID());
    }

    public UUID value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatMessageId that = (ChatMessageId) o;
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
