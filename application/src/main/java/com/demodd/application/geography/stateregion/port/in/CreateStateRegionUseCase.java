package com.demodd.application.geography.stateregion.port.in;

import com.demodd.application.geography.stateregion.dto.StateRegionResponse;

public interface CreateStateRegionUseCase {

    StateRegionResponse execute(String name);
}
