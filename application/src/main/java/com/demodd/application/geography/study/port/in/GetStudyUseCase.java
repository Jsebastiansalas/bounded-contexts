package com.demodd.application.geography.study.port.in;

import com.demodd.application.geography.study.dto.StudyResponse;

import java.util.List;
import java.util.UUID;

public interface GetStudyUseCase {

    StudyResponse getById(UUID id);

    List<StudyResponse> getAll();
}
