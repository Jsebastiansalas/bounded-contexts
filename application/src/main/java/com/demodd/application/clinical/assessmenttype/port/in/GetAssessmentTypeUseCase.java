package com.demodd.application.clinical.assessmenttype.port.in;

import com.demodd.application.clinical.assessmenttype.dto.AssessmentTypeResponse;

import java.util.List;
import java.util.UUID;

public interface GetAssessmentTypeUseCase {

    AssessmentTypeResponse getById(UUID id);

    List<AssessmentTypeResponse> getAll();
}
