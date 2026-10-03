package com.demodd.application.geography.professionaltype.port.in;

import com.demodd.application.geography.professionaltype.dto.ProfessionalTypeResponse;

import java.util.List;
import java.util.UUID;

public interface GetProfessionalTypeUseCase {

    ProfessionalTypeResponse getById(UUID id);

    List<ProfessionalTypeResponse> getAll();
}
