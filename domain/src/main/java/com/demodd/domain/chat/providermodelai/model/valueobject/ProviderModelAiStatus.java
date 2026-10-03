package com.demodd.domain.chat.providermodelai.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;

public class ProviderModelAiStatus implements ValueObject {

    private final String value;

    public ProviderModelAiStatus(String value) {
        this.value = value != null ? value.trim().toUpperCase() : "ACTIVE";
    }

    public static ProviderModelAiStatus of(String value) {
        return new ProviderModelAiStatus(value);
    }

    public static ProviderModelAiStatus active() {
        return new ProviderModelAiStatus("ACTIVE");
    }

    public static ProviderModelAiStatus inactive() {
        return new ProviderModelAiStatus("INACTIVE");
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProviderModelAiStatus that = (ProviderModelAiStatus) o;
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
