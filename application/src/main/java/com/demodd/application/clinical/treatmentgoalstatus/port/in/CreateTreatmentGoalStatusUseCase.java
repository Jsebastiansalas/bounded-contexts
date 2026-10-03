package com.demodd.application.clinical.treatmentgoalstatus.port.in;

import com.demodd.application.clinical.treatmentgoalstatus.dto.TreatmentGoalStatusResponse;

public interface CreateTreatmentGoalStatusUseCase {

    TreatmentGoalStatusResponse execute(String name);
}
