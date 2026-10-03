package com.demodd.application.clinical.treatmentplan.port.in;

import java.util.UUID;

public interface DeleteTreatmentPlanUseCase {

    void execute(UUID id);
}
