package com.demodd.application.clinical.riskassessment.port.in;

import com.demodd.application.clinical.riskassessment.dto.RiskAssessmentResponse;

import java.util.List;
import java.util.UUID;

public interface GetRiskAssessmentUseCase {

    RiskAssessmentResponse getById(UUID id);

    List<RiskAssessmentResponse> getAll();
}
