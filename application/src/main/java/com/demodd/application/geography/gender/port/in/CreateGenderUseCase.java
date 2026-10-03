package com.demodd.application.geography.gender.port.in;

import com.demodd.application.geography.gender.dto.GenderResponse;

public interface CreateGenderUseCase {

    GenderResponse execute(String name);
}
