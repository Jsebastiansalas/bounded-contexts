package com.demodd.application.clinical.encounter.port.in;

import java.util.UUID;

public interface DeleteEncounterUseCase {

    void execute(UUID id);
}
