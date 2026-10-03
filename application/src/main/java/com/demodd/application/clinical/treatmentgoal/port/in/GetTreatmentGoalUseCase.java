package com.demodd.application.clinical.treatmentgoal.port.in;

import com.demodd.application.clinical.treatmentgoal.dto.TreatmentGoalResponse;

import java.util.List;
import java.util.UUID;

public interface GetTreatmentGoalUseCase {

    TreatmentGoalResponse getById(UUID id);

    List<TreatmentGoalResponse> getAll();
}
