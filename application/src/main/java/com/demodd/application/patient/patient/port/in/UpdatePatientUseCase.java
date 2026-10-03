package com.demodd.application.patient.patient.port.in;

import com.demodd.application.patient.patient.dto.PatientResponse;

import java.util.UUID;

public interface UpdatePatientUseCase {

    PatientResponse execute(UUID id, String name, String status);
}
