package com.demodd.application.geography.stateregion.port.in;

import com.demodd.application.geography.stateregion.dto.StateRegionResponse;

import java.util.UUID;

public interface UpdateStateRegionUseCase {

    StateRegionResponse execute(UUID id, String name, String status);
}
