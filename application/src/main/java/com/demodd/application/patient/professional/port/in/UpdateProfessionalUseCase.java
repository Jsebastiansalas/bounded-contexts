package com.demodd.application.patient.professional.port.in;

import com.demodd.application.patient.professional.dto.ProfessionalResponse;

import java.util.UUID;

public interface UpdateProfessionalUseCase {

    ProfessionalResponse execute(UUID id, String name, String status);
}
