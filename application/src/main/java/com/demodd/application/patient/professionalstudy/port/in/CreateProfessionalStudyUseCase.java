package com.demodd.application.patient.professionalstudy.port.in;

import com.demodd.application.patient.professionalstudy.dto.ProfessionalStudyResponse;

public interface CreateProfessionalStudyUseCase {

    ProfessionalStudyResponse execute(String name);
}
