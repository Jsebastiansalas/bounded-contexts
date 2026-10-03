package com.demodd.application.clinical.assessmenttype.port.in;

import java.util.UUID;

public interface DeleteAssessmentTypeUseCase {

    void execute(UUID id);
}
