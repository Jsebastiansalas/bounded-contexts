package com.demodd.application.clinical.riskassessment.port.in;

import com.demodd.application.clinical.riskassessment.dto.RiskAssessmentResponse;

public interface CreateRiskAssessmentUseCase {

    RiskAssessmentResponse execute(String name);
}
