package com.demodd.domain.chat.providermodelai.model.aggregate;

import com.demodd.domain.common.AggregateRoot;
import com.demodd.domain.chat.providermodelai.event.ProviderModelAiCreatedEvent;
import com.demodd.domain.chat.providermodelai.event.ProviderModelAiUpdatedEvent;
import com.demodd.domain.chat.providermodelai.model.valueobject.ProviderModelAiId;
import com.demodd.domain.chat.providermodelai.model.valueobject.ProviderModelAiName;
import com.demodd.domain.chat.providermodelai.model.valueobject.ProviderModelAiStatus;

import java.time.Instant;
import java.util.Objects;

public class ProviderModelAi extends AggregateRoot<ProviderModelAiId> {

    private final ProviderModelAiId id;
    private ProviderModelAiName name;
    private ProviderModelAiStatus status;
    private final Instant createdAt;
    private Instant updatedAt;

    public ProviderModelAi(ProviderModelAiId id, ProviderModelAiName name, ProviderModelAiStatus status, Instant createdAt, Instant updatedAt) {
        this.id = Objects.requireNonNull(id, "El identificador no puede ser nulo");
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = status != null ? status : ProviderModelAiStatus.active();
        this.createdAt = createdAt != null ? createdAt : Instant.now();
        this.updatedAt = updatedAt != null ? updatedAt : Instant.now();
    }

    public static ProviderModelAi create(ProviderModelAiName name) {
        ProviderModelAiId id = ProviderModelAiId.random();
        ProviderModelAi entity = new ProviderModelAi(id, name, ProviderModelAiStatus.active(), Instant.now(), Instant.now());
        entity.recordEvent(new ProviderModelAiCreatedEvent(id.value(), entity.getCreatedAt()));
        return entity;
    }

    public void update(ProviderModelAiName name, ProviderModelAiStatus status) {
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = Objects.requireNonNull(status, "El estado no puede ser nulo");
        this.updatedAt = Instant.now();
        recordEvent(new ProviderModelAiUpdatedEvent(this.id.value(), this.updatedAt));
    }

    @Override
    public ProviderModelAiId getId() {
        return id;
    }

    public ProviderModelAiName getName() {
        return name;
    }

    public ProviderModelAiStatus getStatus() {
        return status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
