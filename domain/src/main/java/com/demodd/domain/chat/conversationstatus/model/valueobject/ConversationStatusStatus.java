package com.demodd.domain.chat.conversationstatus.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;

public class ConversationStatusStatus implements ValueObject {

    private final String value;

    public ConversationStatusStatus(String value) {
        this.value = value != null ? value.trim().toUpperCase() : "ACTIVE";
    }

    public static ConversationStatusStatus of(String value) {
        return new ConversationStatusStatus(value);
    }

    public static ConversationStatusStatus active() {
        return new ConversationStatusStatus("ACTIVE");
    }

    public static ConversationStatusStatus inactive() {
        return new ConversationStatusStatus("INACTIVE");
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConversationStatusStatus that = (ConversationStatusStatus) o;
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
