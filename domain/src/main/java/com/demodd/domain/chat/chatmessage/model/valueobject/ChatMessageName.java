package com.demodd.domain.chat.chatmessage.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;

public class ChatMessageName implements ValueObject {

    private final String value;

    public ChatMessageName(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("El valor de ChatMessageName no puede estar vacio");
        }
        this.value = value.trim();
    }

    public static ChatMessageName of(String value) {
        return new ChatMessageName(value);
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatMessageName that = (ChatMessageName) o;
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
