package com.demodd.application.clinical.encounter.port.in;

import com.demodd.application.clinical.encounter.dto.EncounterResponse;

import java.util.UUID;

public interface UpdateEncounterUseCase {

    EncounterResponse execute(UUID id, String name, String status);
}
