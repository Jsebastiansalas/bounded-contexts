package com.demodd.application.geography.stateregion.service;

import com.demodd.application.geography.stateregion.dto.StateRegionResponse;
import com.demodd.application.geography.stateregion.port.in.CreateStateRegionUseCase;
import com.demodd.application.geography.stateregion.port.in.DeleteStateRegionUseCase;
import com.demodd.application.geography.stateregion.port.in.GetStateRegionUseCase;
import com.demodd.application.geography.stateregion.port.in.UpdateStateRegionUseCase;
import com.demodd.domain.geography.stateregion.exception.StateRegionNotFoundException;
import com.demodd.domain.geography.stateregion.model.aggregate.StateRegion;
import com.demodd.domain.geography.stateregion.model.valueobject.StateRegionId;
import com.demodd.domain.geography.stateregion.model.valueobject.StateRegionName;
import com.demodd.domain.geography.stateregion.model.valueobject.StateRegionStatus;
import com.demodd.domain.geography.stateregion.port.repository.StateRegionRepositoryPort;

import java.util.List;
import java.util.UUID;

public class StateRegionApplicationService implements
        CreateStateRegionUseCase,
        UpdateStateRegionUseCase,
        GetStateRegionUseCase,
        DeleteStateRegionUseCase {

    private final StateRegionRepositoryPort repository;

    public StateRegionApplicationService(StateRegionRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public StateRegionResponse execute(String name) {
        StateRegion entity = StateRegion.create(StateRegionName.of(name));
        StateRegion saved = repository.save(entity);
        return StateRegionResponse.fromDomain(saved);
    }

    @Override
    public StateRegionResponse execute(UUID id, String name, String status) {
        StateRegionId entityId = StateRegionId.of(id);
        StateRegion entity = repository.findById(entityId)
                .orElseThrow(() -> new StateRegionNotFoundException(entityId));

        entity.update(StateRegionName.of(name), StateRegionStatus.of(status));
        StateRegion updated = repository.save(entity);
        return StateRegionResponse.fromDomain(updated);
    }

    @Override
    public StateRegionResponse getById(UUID id) {
        StateRegionId entityId = StateRegionId.of(id);
        return repository.findById(entityId)
                .map(StateRegionResponse::fromDomain)
                .orElseThrow(() -> new StateRegionNotFoundException(entityId));
    }

    @Override
    public List<StateRegionResponse> getAll() {
        return repository.findAll().stream()
                .map(StateRegionResponse::fromDomain)
                .toList();
    }

    @Override
    public void execute(UUID id) {
        StateRegionId entityId = StateRegionId.of(id);
        if (!repository.existsById(entityId)) {
            throw new StateRegionNotFoundException(entityId);
        }
        repository.deleteById(entityId);
    }
}
