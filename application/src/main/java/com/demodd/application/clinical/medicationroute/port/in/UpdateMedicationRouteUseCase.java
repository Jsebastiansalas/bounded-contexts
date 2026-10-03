package com.demodd.application.clinical.medicationroute.port.in;

import com.demodd.application.clinical.medicationroute.dto.MedicationRouteResponse;

import java.util.UUID;

public interface UpdateMedicationRouteUseCase {

    MedicationRouteResponse execute(UUID id, String name, String status);
}
