package com.demodd.domain.chat.chatairunmetric.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;

public class ChatAiRunMetricName implements ValueObject {

    private final String value;

    public ChatAiRunMetricName(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("El valor de ChatAiRunMetricName no puede estar vacio");
        }
        this.value = value.trim();
    }

    public static ChatAiRunMetricName of(String value) {
        return new ChatAiRunMetricName(value);
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatAiRunMetricName that = (ChatAiRunMetricName) o;
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
