package com.demodd.application.patient.professionalstudy.port.in;

import com.demodd.application.patient.professionalstudy.dto.ProfessionalStudyResponse;

import java.util.List;
import java.util.UUID;

public interface GetProfessionalStudyUseCase {

    ProfessionalStudyResponse getById(UUID id);

    List<ProfessionalStudyResponse> getAll();
}
