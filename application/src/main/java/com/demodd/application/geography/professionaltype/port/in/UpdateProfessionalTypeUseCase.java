package com.demodd.application.geography.professionaltype.port.in;

import com.demodd.application.geography.professionaltype.dto.ProfessionalTypeResponse;

import java.util.UUID;

public interface UpdateProfessionalTypeUseCase {

    ProfessionalTypeResponse execute(UUID id, String name, String status);
}
