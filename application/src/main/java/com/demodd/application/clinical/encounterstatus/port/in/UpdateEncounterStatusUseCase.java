package com.demodd.application.clinical.encounterstatus.port.in;

import com.demodd.application.clinical.encounterstatus.dto.EncounterStatusResponse;

import java.util.UUID;

public interface UpdateEncounterStatusUseCase {

    EncounterStatusResponse execute(UUID id, String name, String status);
}
