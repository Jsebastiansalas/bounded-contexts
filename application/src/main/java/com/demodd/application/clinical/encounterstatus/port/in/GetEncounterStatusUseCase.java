package com.demodd.application.clinical.encounterstatus.port.in;

import com.demodd.application.clinical.encounterstatus.dto.EncounterStatusResponse;

import java.util.List;
import java.util.UUID;

public interface GetEncounterStatusUseCase {

    EncounterStatusResponse getById(UUID id);

    List<EncounterStatusResponse> getAll();
}
