package com.demodd.application.clinical.encounter.port.in;

import com.demodd.application.clinical.encounter.dto.EncounterResponse;

public interface CreateEncounterUseCase {

    EncounterResponse execute(String name);
}
