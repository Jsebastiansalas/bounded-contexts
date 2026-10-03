package com.demodd.domain.clinical.risklevel.model.aggregate;

import com.demodd.domain.common.AggregateRoot;
import com.demodd.domain.clinical.risklevel.event.RiskLevelCreatedEvent;
import com.demodd.domain.clinical.risklevel.event.RiskLevelUpdatedEvent;
import com.demodd.domain.clinical.risklevel.model.valueobject.RiskLevelId;
import com.demodd.domain.clinical.risklevel.model.valueobject.RiskLevelName;
import com.demodd.domain.clinical.risklevel.model.valueobject.RiskLevelStatus;

import java.time.Instant;
import java.util.Objects;

public class RiskLevel extends AggregateRoot<RiskLevelId> {

    private final RiskLevelId id;
    private RiskLevelName name;
    private RiskLevelStatus status;
    private final Instant createdAt;
    private Instant updatedAt;

    public RiskLevel(RiskLevelId id, RiskLevelName name, RiskLevelStatus status, Instant createdAt, Instant updatedAt) {
        this.id = Objects.requireNonNull(id, "El identificador no puede ser nulo");
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = status != null ? status : RiskLevelStatus.active();
        this.createdAt = createdAt != null ? createdAt : Instant.now();
        this.updatedAt = updatedAt != null ? updatedAt : Instant.now();
    }

    public static RiskLevel create(RiskLevelName name) {
        RiskLevelId id = RiskLevelId.random();
        RiskLevel entity = new RiskLevel(id, name, RiskLevelStatus.active(), Instant.now(), Instant.now());
        entity.recordEvent(new RiskLevelCreatedEvent(id.value(), entity.getCreatedAt()));
        return entity;
    }

    public void update(RiskLevelName name, RiskLevelStatus status) {
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = Objects.requireNonNull(status, "El estado no puede ser nulo");
        this.updatedAt = Instant.now();
        recordEvent(new RiskLevelUpdatedEvent(this.id.value(), this.updatedAt));
    }

    @Override
    public RiskLevelId getId() {
        return id;
    }

    public RiskLevelName getName() {
        return name;
    }

    public RiskLevelStatus getStatus() {
        return status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
