package com.demodd.application.geography.stateregion.port.in;

import com.demodd.application.geography.stateregion.dto.StateRegionResponse;

import java.util.List;
import java.util.UUID;

public interface GetStateRegionUseCase {

    StateRegionResponse getById(UUID id);

    List<StateRegionResponse> getAll();
}
