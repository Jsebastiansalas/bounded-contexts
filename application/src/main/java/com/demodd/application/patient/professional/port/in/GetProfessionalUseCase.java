package com.demodd.application.patient.professional.port.in;

import com.demodd.application.patient.professional.dto.ProfessionalResponse;

import java.util.List;
import java.util.UUID;

public interface GetProfessionalUseCase {

    ProfessionalResponse getById(UUID id);

    List<ProfessionalResponse> getAll();
}
