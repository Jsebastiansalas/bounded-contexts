package com.demodd.application.geography.gender.port.in;

import com.demodd.application.geography.gender.dto.GenderResponse;

import java.util.List;
import java.util.UUID;

public interface GetGenderUseCase {

    GenderResponse getById(UUID id);

    List<GenderResponse> getAll();
}
