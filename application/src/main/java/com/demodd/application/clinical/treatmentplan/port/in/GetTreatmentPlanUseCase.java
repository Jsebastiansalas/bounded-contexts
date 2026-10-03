package com.demodd.application.clinical.treatmentplan.port.in;

import com.demodd.application.clinical.treatmentplan.dto.TreatmentPlanResponse;

import java.util.List;
import java.util.UUID;

public interface GetTreatmentPlanUseCase {

    TreatmentPlanResponse getById(UUID id);

    List<TreatmentPlanResponse> getAll();
}
