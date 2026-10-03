package com.demodd.application.clinical.treatmentgoalstatus.port.in;

import com.demodd.application.clinical.treatmentgoalstatus.dto.TreatmentGoalStatusResponse;

import java.util.UUID;

public interface UpdateTreatmentGoalStatusUseCase {

    TreatmentGoalStatusResponse execute(UUID id, String name, String status);
}
