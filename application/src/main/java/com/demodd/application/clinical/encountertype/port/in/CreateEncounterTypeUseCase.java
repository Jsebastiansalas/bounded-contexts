package com.demodd.application.clinical.encountertype.port.in;

import com.demodd.application.clinical.encountertype.dto.EncounterTypeResponse;

public interface CreateEncounterTypeUseCase {

    EncounterTypeResponse execute(String name);
}
