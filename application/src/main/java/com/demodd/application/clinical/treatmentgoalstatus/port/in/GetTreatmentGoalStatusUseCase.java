package com.demodd.application.clinical.treatmentgoalstatus.port.in;

import com.demodd.application.clinical.treatmentgoalstatus.dto.TreatmentGoalStatusResponse;

import java.util.List;
import java.util.UUID;

public interface GetTreatmentGoalStatusUseCase {

    TreatmentGoalStatusResponse getById(UUID id);

    List<TreatmentGoalStatusResponse> getAll();
}
