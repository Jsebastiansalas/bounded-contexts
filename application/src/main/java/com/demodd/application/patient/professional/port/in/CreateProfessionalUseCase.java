package com.demodd.application.patient.professional.port.in;

import com.demodd.application.patient.professional.dto.ProfessionalResponse;

public interface CreateProfessionalUseCase {

    ProfessionalResponse execute(String name);
}
