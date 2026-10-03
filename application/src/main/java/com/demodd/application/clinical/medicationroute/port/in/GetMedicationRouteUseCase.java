package com.demodd.application.clinical.medicationroute.port.in;

import com.demodd.application.clinical.medicationroute.dto.MedicationRouteResponse;

import java.util.List;
import java.util.UUID;

public interface GetMedicationRouteUseCase {

    MedicationRouteResponse getById(UUID id);

    List<MedicationRouteResponse> getAll();
}
