package com.demodd.application.clinical.encountermodality.port.in;

import com.demodd.application.clinical.encountermodality.dto.EncounterModalityResponse;

import java.util.UUID;

public interface UpdateEncounterModalityUseCase {

    EncounterModalityResponse execute(UUID id, String name, String status);
}
