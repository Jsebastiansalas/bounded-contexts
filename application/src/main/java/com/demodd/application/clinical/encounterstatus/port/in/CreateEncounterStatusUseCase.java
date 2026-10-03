package com.demodd.application.clinical.encounterstatus.port.in;

import com.demodd.application.clinical.encounterstatus.dto.EncounterStatusResponse;

public interface CreateEncounterStatusUseCase {

    EncounterStatusResponse execute(String name);
}
