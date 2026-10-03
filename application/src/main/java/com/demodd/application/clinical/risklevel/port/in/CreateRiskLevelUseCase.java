package com.demodd.application.clinical.risklevel.port.in;

import com.demodd.application.clinical.risklevel.dto.RiskLevelResponse;

public interface CreateRiskLevelUseCase {

    RiskLevelResponse execute(String name);
}
