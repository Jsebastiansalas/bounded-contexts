package com.demodd.domain.chat.chatairun.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;

public class ChatAiRunName implements ValueObject {

    private final String value;

    public ChatAiRunName(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("El valor de ChatAiRunName no puede estar vacio");
        }
        this.value = value.trim();
    }

    public static ChatAiRunName of(String value) {
        return new ChatAiRunName(value);
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatAiRunName that = (ChatAiRunName) o;
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
