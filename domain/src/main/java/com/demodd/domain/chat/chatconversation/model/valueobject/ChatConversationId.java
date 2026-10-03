package com.demodd.domain.chat.chatconversation.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;
import java.util.UUID;

public class ChatConversationId implements ValueObject {

    private final UUID value;

    public ChatConversationId(UUID value) {
        this.value = Objects.requireNonNull(value, "El valor de ChatConversationId no puede ser nulo");
    }

    public static ChatConversationId of(UUID value) {
        return new ChatConversationId(value);
    }

    public static ChatConversationId of(String value) {
        return new ChatConversationId(UUID.fromString(value));
    }

    public static ChatConversationId random() {
        return new ChatConversationId(UUID.randomUUID());
    }

    public UUID value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatConversationId that = (ChatConversationId) o;
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
