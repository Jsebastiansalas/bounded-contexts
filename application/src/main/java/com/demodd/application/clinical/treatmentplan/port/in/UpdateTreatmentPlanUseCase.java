package com.demodd.application.clinical.treatmentplan.port.in;

import com.demodd.application.clinical.treatmentplan.dto.TreatmentPlanResponse;

import java.util.UUID;

public interface UpdateTreatmentPlanUseCase {

    TreatmentPlanResponse execute(UUID id, String name, String status);
}
