package com.demodd.application.clinical.medicationroute.port.in;

import java.util.UUID;

public interface DeleteMedicationRouteUseCase {

    void execute(UUID id);
}
