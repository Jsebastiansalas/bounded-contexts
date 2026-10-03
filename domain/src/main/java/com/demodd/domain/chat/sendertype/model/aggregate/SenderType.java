package com.demodd.domain.chat.sendertype.model.aggregate;

import com.demodd.domain.common.AggregateRoot;
import com.demodd.domain.chat.sendertype.event.SenderTypeCreatedEvent;
import com.demodd.domain.chat.sendertype.event.SenderTypeUpdatedEvent;
import com.demodd.domain.chat.sendertype.model.valueobject.SenderTypeId;
import com.demodd.domain.chat.sendertype.model.valueobject.SenderTypeName;
import com.demodd.domain.chat.sendertype.model.valueobject.SenderTypeStatus;

import java.time.Instant;
import java.util.Objects;

public class SenderType extends AggregateRoot<SenderTypeId> {

    private final SenderTypeId id;
    private SenderTypeName name;
    private SenderTypeStatus status;
    private final Instant createdAt;
    private Instant updatedAt;

    public SenderType(SenderTypeId id, SenderTypeName name, SenderTypeStatus status, Instant createdAt, Instant updatedAt) {
        this.id = Objects.requireNonNull(id, "El identificador no puede ser nulo");
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = status != null ? status : SenderTypeStatus.active();
        this.createdAt = createdAt != null ? createdAt : Instant.now();
        this.updatedAt = updatedAt != null ? updatedAt : Instant.now();
    }

    public static SenderType create(SenderTypeName name) {
        SenderTypeId id = SenderTypeId.random();
        SenderType entity = new SenderType(id, name, SenderTypeStatus.active(), Instant.now(), Instant.now());
        entity.recordEvent(new SenderTypeCreatedEvent(id.value(), entity.getCreatedAt()));
        return entity;
    }

    public void update(SenderTypeName name, SenderTypeStatus status) {
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = Objects.requireNonNull(status, "El estado no puede ser nulo");
        this.updatedAt = Instant.now();
        recordEvent(new SenderTypeUpdatedEvent(this.id.value(), this.updatedAt));
    }

    @Override
    public SenderTypeId getId() {
        return id;
    }

    public SenderTypeName getName() {
        return name;
    }

    public SenderTypeStatus getStatus() {
        return status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
