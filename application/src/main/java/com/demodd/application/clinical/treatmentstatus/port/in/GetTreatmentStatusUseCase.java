package com.demodd.application.clinical.treatmentstatus.port.in;

import com.demodd.application.clinical.treatmentstatus.dto.TreatmentStatusResponse;

import java.util.List;
import java.util.UUID;

public interface GetTreatmentStatusUseCase {

    TreatmentStatusResponse getById(UUID id);

    List<TreatmentStatusResponse> getAll();
}
