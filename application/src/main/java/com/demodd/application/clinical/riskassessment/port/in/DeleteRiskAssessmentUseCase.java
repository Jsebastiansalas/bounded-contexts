package com.demodd.application.clinical.riskassessment.port.in;

import java.util.UUID;

public interface DeleteRiskAssessmentUseCase {

    void execute(UUID id);
}
