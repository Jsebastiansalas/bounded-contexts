package com.demodd.application.clinical.treatmentplan.port.in;

import com.demodd.application.clinical.treatmentplan.dto.TreatmentPlanResponse;

public interface CreateTreatmentPlanUseCase {

    TreatmentPlanResponse execute(String name);
}
