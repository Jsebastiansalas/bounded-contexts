package com.demodd.application.clinical.encountertype.port.in;

import com.demodd.application.clinical.encountertype.dto.EncounterTypeResponse;

import java.util.UUID;

public interface UpdateEncounterTypeUseCase {

    EncounterTypeResponse execute(UUID id, String name, String status);
}
