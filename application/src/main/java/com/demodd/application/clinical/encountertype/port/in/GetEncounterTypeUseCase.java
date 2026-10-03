package com.demodd.application.clinical.encountertype.port.in;

import com.demodd.application.clinical.encountertype.dto.EncounterTypeResponse;

import java.util.List;
import java.util.UUID;

public interface GetEncounterTypeUseCase {

    EncounterTypeResponse getById(UUID id);

    List<EncounterTypeResponse> getAll();
}
