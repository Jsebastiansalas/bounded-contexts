package com.demodd.application.geography.gender.port.in;

import com.demodd.application.geography.gender.dto.GenderResponse;

import java.util.UUID;

public interface UpdateGenderUseCase {

    GenderResponse execute(UUID id, String name, String status);
}
