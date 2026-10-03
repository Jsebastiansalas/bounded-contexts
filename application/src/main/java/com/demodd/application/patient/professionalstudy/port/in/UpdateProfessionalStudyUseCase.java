package com.demodd.application.patient.professionalstudy.port.in;

import com.demodd.application.patient.professionalstudy.dto.ProfessionalStudyResponse;

import java.util.UUID;

public interface UpdateProfessionalStudyUseCase {

    ProfessionalStudyResponse execute(UUID id, String name, String status);
}
