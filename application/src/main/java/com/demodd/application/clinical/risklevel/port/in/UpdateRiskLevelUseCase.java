package com.demodd.application.clinical.risklevel.port.in;

import com.demodd.application.clinical.risklevel.dto.RiskLevelResponse;

import java.util.UUID;

public interface UpdateRiskLevelUseCase {

    RiskLevelResponse execute(UUID id, String name, String status);
}
