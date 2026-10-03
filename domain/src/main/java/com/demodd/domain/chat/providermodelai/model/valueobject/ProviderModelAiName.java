package com.demodd.domain.chat.providermodelai.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;

public class ProviderModelAiName implements ValueObject {

    private final String value;

    public ProviderModelAiName(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("El valor de ProviderModelAiName no puede estar vacio");
        }
        this.value = value.trim();
    }

    public static ProviderModelAiName of(String value) {
        return new ProviderModelAiName(value);
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProviderModelAiName that = (ProviderModelAiName) o;
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
