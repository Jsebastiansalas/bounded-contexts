package com.demodd.application.clinical.risklevel.port.in;

import com.demodd.application.clinical.risklevel.dto.RiskLevelResponse;

import java.util.List;
import java.util.UUID;

public interface GetRiskLevelUseCase {

    RiskLevelResponse getById(UUID id);

    List<RiskLevelResponse> getAll();
}
