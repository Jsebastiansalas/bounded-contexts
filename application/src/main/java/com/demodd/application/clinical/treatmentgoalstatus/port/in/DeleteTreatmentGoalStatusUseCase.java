package com.demodd.application.clinical.treatmentgoalstatus.port.in;

import java.util.UUID;

public interface DeleteTreatmentGoalStatusUseCase {

    void execute(UUID id);
}
