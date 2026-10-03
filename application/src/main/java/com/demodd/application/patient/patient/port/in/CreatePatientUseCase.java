package com.demodd.application.patient.patient.port.in;

import com.demodd.application.patient.patient.dto.PatientResponse;

public interface CreatePatientUseCase {

    PatientResponse execute(String name);
}
