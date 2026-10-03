package com.demodd.domain.chat.providermodelai.model.valueobject;

import com.demodd.domain.common.ValueObject;

import java.util.Objects;
import java.util.UUID;

public class ProviderModelAiId implements ValueObject {

    private final UUID value;

    public ProviderModelAiId(UUID value) {
        this.value = Objects.requireNonNull(value, "El valor de ProviderModelAiId no puede ser nulo");
    }

    public static ProviderModelAiId of(UUID value) {
        return new ProviderModelAiId(value);
    }

    public static ProviderModelAiId of(String value) {
        return new ProviderModelAiId(UUID.fromString(value));
    }

    public static ProviderModelAiId random() {
        return new ProviderModelAiId(UUID.randomUUID());
    }

    public UUID value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProviderModelAiId that = (ProviderModelAiId) o;
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
