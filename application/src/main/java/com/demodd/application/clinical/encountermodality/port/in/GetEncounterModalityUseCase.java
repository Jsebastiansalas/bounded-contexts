package com.demodd.application.clinical.encountermodality.port.in;

import com.demodd.application.clinical.encountermodality.dto.EncounterModalityResponse;

import java.util.List;
import java.util.UUID;

public interface GetEncounterModalityUseCase {

    EncounterModalityResponse getById(UUID id);

    List<EncounterModalityResponse> getAll();
}
