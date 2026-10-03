package com.demodd.application.clinical.treatmentstatus.port.in;

import com.demodd.application.clinical.treatmentstatus.dto.TreatmentStatusResponse;

public interface CreateTreatmentStatusUseCase {

    TreatmentStatusResponse execute(String name);
}
