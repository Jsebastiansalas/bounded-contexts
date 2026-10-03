package com.demodd.application.clinical.treatmentgoal.port.in;

import com.demodd.application.clinical.treatmentgoal.dto.TreatmentGoalResponse;

public interface CreateTreatmentGoalUseCase {

    TreatmentGoalResponse execute(String name);
}
