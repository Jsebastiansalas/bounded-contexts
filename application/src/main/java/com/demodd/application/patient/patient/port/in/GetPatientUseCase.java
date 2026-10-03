package com.demodd.application.patient.patient.port.in;

import com.demodd.application.patient.patient.dto.PatientResponse;

import java.util.List;
import java.util.UUID;

public interface GetPatientUseCase {

    PatientResponse getById(UUID id);

    List<PatientResponse> getAll();
}
