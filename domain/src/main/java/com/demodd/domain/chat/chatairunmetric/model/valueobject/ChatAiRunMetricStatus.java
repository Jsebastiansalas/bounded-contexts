package com.demodd.domain.chat.chatairunmetric.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;

public class ChatAiRunMetricStatus implements ValueObject {

    private final String value;

    public ChatAiRunMetricStatus(String value) {
        this.value = value != null ? value.trim().toUpperCase() : "ACTIVE";
    }

    public static ChatAiRunMetricStatus of(String value) {
        return new ChatAiRunMetricStatus(value);
    }

    public static ChatAiRunMetricStatus active() {
        return new ChatAiRunMetricStatus("ACTIVE");
    }

    public static ChatAiRunMetricStatus inactive() {
        return new ChatAiRunMetricStatus("INACTIVE");
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatAiRunMetricStatus that = (ChatAiRunMetricStatus) o;
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
