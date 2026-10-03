package com.demodd.application.clinical.encountermodality.port.in;

import com.demodd.application.clinical.encountermodality.dto.EncounterModalityResponse;

public interface CreateEncounterModalityUseCase {

    EncounterModalityResponse execute(String name);
}
