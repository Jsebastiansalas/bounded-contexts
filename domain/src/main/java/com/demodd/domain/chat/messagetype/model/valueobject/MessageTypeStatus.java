package com.demodd.domain.chat.messagetype.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;

public class MessageTypeStatus implements ValueObject {

    private final String value;

    public MessageTypeStatus(String value) {
        this.value = value != null ? value.trim().toUpperCase() : "ACTIVE";
    }

    public static MessageTypeStatus of(String value) {
        return new MessageTypeStatus(value);
    }

    public static MessageTypeStatus active() {
        return new MessageTypeStatus("ACTIVE");
    }

    public static MessageTypeStatus inactive() {
        return new MessageTypeStatus("INACTIVE");
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageTypeStatus that = (MessageTypeStatus) o;
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
