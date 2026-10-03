package com.demodd.application.geography.study.port.in;

import com.demodd.application.geography.study.dto.StudyResponse;

import java.util.UUID;

public interface UpdateStudyUseCase {

    StudyResponse execute(UUID id, String name, String status);
}
