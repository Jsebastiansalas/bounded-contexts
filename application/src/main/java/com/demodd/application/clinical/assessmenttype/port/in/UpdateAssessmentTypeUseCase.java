package com.demodd.application.clinical.assessmenttype.port.in;

import com.demodd.application.clinical.assessmenttype.dto.AssessmentTypeResponse;

import java.util.UUID;

public interface UpdateAssessmentTypeUseCase {

    AssessmentTypeResponse execute(UUID id, String name, String status);
}
