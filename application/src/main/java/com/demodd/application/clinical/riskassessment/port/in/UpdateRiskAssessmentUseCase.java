package com.demodd.application.clinical.riskassessment.port.in;

import com.demodd.application.clinical.riskassessment.dto.RiskAssessmentResponse;

import java.util.UUID;

public interface UpdateRiskAssessmentUseCase {

    RiskAssessmentResponse execute(UUID id, String name, String status);
}
