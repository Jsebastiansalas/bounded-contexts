package com.demodd.application.geography.professionaltype.port.in;

import com.demodd.application.geography.professionaltype.dto.ProfessionalTypeResponse;

public interface CreateProfessionalTypeUseCase {

    ProfessionalTypeResponse execute(String name);
}
