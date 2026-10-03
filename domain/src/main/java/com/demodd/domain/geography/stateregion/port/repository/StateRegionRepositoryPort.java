package com.demodd.domain.geography.stateregion.port.repository;

import com.demodd.domain.geography.stateregion.model.aggregate.StateRegion;
import com.demodd.domain.geography.stateregion.model.valueobject.StateRegionId;

import java.util.List;
import java.util.Optional;

public interface StateRegionRepositoryPort {

    StateRegion save(StateRegion entity);

    Optional<StateRegion> findById(StateRegionId id);

    List<StateRegion> findAll();

    void deleteById(StateRegionId id);

    boolean existsById(StateRegionId id);
}
