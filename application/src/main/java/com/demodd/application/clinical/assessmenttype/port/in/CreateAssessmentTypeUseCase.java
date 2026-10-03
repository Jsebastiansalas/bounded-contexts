package com.demodd.application.clinical.assessmenttype.port.in;

import com.demodd.application.clinical.assessmenttype.dto.AssessmentTypeResponse;

public interface CreateAssessmentTypeUseCase {

    AssessmentTypeResponse execute(String name);
}
