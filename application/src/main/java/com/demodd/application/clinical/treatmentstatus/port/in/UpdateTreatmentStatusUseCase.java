package com.demodd.application.clinical.treatmentstatus.port.in;

import com.demodd.application.clinical.treatmentstatus.dto.TreatmentStatusResponse;

import java.util.UUID;

public interface UpdateTreatmentStatusUseCase {

    TreatmentStatusResponse execute(UUID id, String name, String status);
}
