package com.demodd.domain.chat.aimodel.model.aggregate;

import com.demodd.domain.common.AggregateRoot;
import com.demodd.domain.chat.aimodel.event.AiModelCreatedEvent;
import com.demodd.domain.chat.aimodel.event.AiModelUpdatedEvent;
import com.demodd.domain.chat.aimodel.model.valueobject.AiModelId;
import com.demodd.domain.chat.aimodel.model.valueobject.AiModelName;
import com.demodd.domain.chat.aimodel.model.valueobject.AiModelStatus;

import java.time.Instant;
import java.util.Objects;

public class AiModel extends AggregateRoot<AiModelId> {

    private final AiModelId id;
    private AiModelName name;
    private AiModelStatus status;
    private final Instant createdAt;
    private Instant updatedAt;

    public AiModel(AiModelId id, AiModelName name, AiModelStatus status, Instant createdAt, Instant updatedAt) {
        this.id = Objects.requireNonNull(id, "El identificador no puede ser nulo");
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = status != null ? status : AiModelStatus.active();
        this.createdAt = createdAt != null ? createdAt : Instant.now();
        this.updatedAt = updatedAt != null ? updatedAt : Instant.now();
    }

    public static AiModel create(AiModelName name) {
        AiModelId id = AiModelId.random();
        AiModel entity = new AiModel(id, name, AiModelStatus.active(), Instant.now(), Instant.now());
        entity.recordEvent(new AiModelCreatedEvent(id.value(), entity.getCreatedAt()));
        return entity;
    }

    public void update(AiModelName name, AiModelStatus status) {
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = Objects.requireNonNull(status, "El estado no puede ser nulo");
        this.updatedAt = Instant.now();
        recordEvent(new AiModelUpdatedEvent(this.id.value(), this.updatedAt));
    }

    @Override
    public AiModelId getId() {
        return id;
    }

    public AiModelName getName() {
        return name;
    }

    public AiModelStatus getStatus() {
        return status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
