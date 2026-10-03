package com.demodd.application.geography.study.port.in;

import com.demodd.application.geography.study.dto.StudyResponse;

public interface CreateStudyUseCase {

    StudyResponse execute(String name);
}
