package com.demodd.application.clinical.encountertype.port.in;

import java.util.UUID;

public interface DeleteEncounterTypeUseCase {

    void execute(UUID id);
}
