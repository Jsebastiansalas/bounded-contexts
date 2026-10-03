package com.demodd.domain.chat.chatairunerror.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;

public class ChatAiRunErrorName implements ValueObject {

    private final String value;

    public ChatAiRunErrorName(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("El valor de ChatAiRunErrorName no puede estar vacio");
        }
        this.value = value.trim();
    }

    public static ChatAiRunErrorName of(String value) {
        return new ChatAiRunErrorName(value);
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatAiRunErrorName that = (ChatAiRunErrorName) o;
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
