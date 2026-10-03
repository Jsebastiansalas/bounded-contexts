package com.demodd.application.clinical.encountermodality.port.in;

import java.util.UUID;

public interface DeleteEncounterModalityUseCase {

    void execute(UUID id);
}
