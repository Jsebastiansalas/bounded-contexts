package com.demodd.domain.chat.conversationstatus.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;

public class ConversationStatusName implements ValueObject {

    private final String value;

    public ConversationStatusName(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("El valor de ConversationStatusName no puede estar vacio");
        }
        this.value = value.trim();
    }

    public static ConversationStatusName of(String value) {
        return new ConversationStatusName(value);
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConversationStatusName that = (ConversationStatusName) o;
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
