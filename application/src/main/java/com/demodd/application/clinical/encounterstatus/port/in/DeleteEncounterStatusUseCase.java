package com.demodd.application.clinical.encounterstatus.port.in;

import java.util.UUID;

public interface DeleteEncounterStatusUseCase {

    void execute(UUID id);
}
