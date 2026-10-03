package com.demodd.domain.chat.chatconversation.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;

public class ChatConversationName implements ValueObject {

    private final String value;

    public ChatConversationName(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("El valor de ChatConversationName no puede estar vacio");
        }
        this.value = value.trim();
    }

    public static ChatConversationName of(String value) {
        return new ChatConversationName(value);
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatConversationName that = (ChatConversationName) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value;
    }
}
