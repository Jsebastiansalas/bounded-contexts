package com.demodd.application.clinical.treatmentgoal.port.in;

import java.util.UUID;

public interface DeleteTreatmentGoalUseCase {

    void execute(UUID id);
}
