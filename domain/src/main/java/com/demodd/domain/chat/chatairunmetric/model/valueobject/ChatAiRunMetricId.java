package com.demodd.domain.chat.chatairunmetric.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;
import java.util.UUID;

public class ChatAiRunMetricId implements ValueObject {

    private final UUID value;

    public ChatAiRunMetricId(UUID value) {
        this.value = Objects.requireNonNull(value, "El valor de ChatAiRunMetricId no puede ser nulo");
    }

    public static ChatAiRunMetricId of(UUID value) {
        return new ChatAiRunMetricId(value);
    }

    public static ChatAiRunMetricId of(String value) {
        return new ChatAiRunMetricId(UUID.fromString(value));
    }

    public static ChatAiRunMetricId random() {
        return new ChatAiRunMetricId(UUID.randomUUID());
    }

    public UUID value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatAiRunMetricId that = (ChatAiRunMetricId) o;
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
