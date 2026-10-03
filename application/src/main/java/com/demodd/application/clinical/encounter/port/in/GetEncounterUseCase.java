package com.demodd.application.clinical.encounter.port.in;

import com.demodd.application.clinical.encounter.dto.EncounterResponse;

import java.util.List;
import java.util.UUID;

public interface GetEncounterUseCase {

    EncounterResponse getById(UUID id);

    List<EncounterResponse> getAll();
}
