package com.demodd.domain.geography.stateregion.model.aggregate;

import com.demodd.domain.common.AggregateRoot;
import com.demodd.domain.geography.stateregion.event.StateRegionCreatedEvent;
import com.demodd.domain.geography.stateregion.event.StateRegionUpdatedEvent;
import com.demodd.domain.geography.stateregion.model.valueobject.StateRegionId;
import com.demodd.domain.geography.stateregion.model.valueobject.StateRegionName;
import com.demodd.domain.geography.stateregion.model.valueobject.StateRegionStatus;

import java.time.Instant;
import java.util.Objects;

public class StateRegion extends AggregateRoot<StateRegionId> {

    private final StateRegionId id;
    private StateRegionName name;
    private StateRegionStatus status;
    private final Instant createdAt;
    private Instant updatedAt;

    public StateRegion(StateRegionId id, StateRegionName name, StateRegionStatus status, Instant createdAt, Instant updatedAt) {
        this.id = Objects.requireNonNull(id, "El identificador no puede ser nulo");
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = status != null ? status : StateRegionStatus.active();
        this.createdAt = createdAt != null ? createdAt : Instant.now();
        this.updatedAt = updatedAt != null ? updatedAt : Instant.now();
    }

    public static StateRegion create(StateRegionName name) {
        StateRegionId id = StateRegionId.random();
        StateRegion entity = new StateRegion(id, name, StateRegionStatus.active(), Instant.now(), Instant.now());
        entity.recordEvent(new StateRegionCreatedEvent(id.value(), entity.getCreatedAt()));
        return entity;
    }

    public void update(StateRegionName name, StateRegionStatus status) {
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.status = Objects.requireNonNull(status, "El estado no puede ser nulo");
        this.updatedAt = Instant.now();
        recordEvent(new StateRegionUpdatedEvent(this.id.value(), this.updatedAt));
    }

    @Override
    public StateRegionId getId() {
        return id;
    }

    public StateRegionName getName() {
        return name;
    }

    public StateRegionStatus getStatus() {
        return status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
