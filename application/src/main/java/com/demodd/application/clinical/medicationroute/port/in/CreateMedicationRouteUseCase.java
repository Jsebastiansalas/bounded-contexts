package com.demodd.application.clinical.medicationroute.port.in;

import com.demodd.application.clinical.medicationroute.dto.MedicationRouteResponse;

public interface CreateMedicationRouteUseCase {

    MedicationRouteResponse execute(String name);
}
