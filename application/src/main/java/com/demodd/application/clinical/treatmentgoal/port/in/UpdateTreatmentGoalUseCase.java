package com.demodd.application.clinical.treatmentgoal.port.in;

import com.demodd.application.clinical.treatmentgoal.dto.TreatmentGoalResponse;

import java.util.UUID;

public interface UpdateTreatmentGoalUseCase {

    TreatmentGoalResponse execute(UUID id, String name, String status);
}
