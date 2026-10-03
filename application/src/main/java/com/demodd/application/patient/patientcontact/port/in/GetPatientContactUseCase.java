package com.demodd.application.patient.patientcontact.port.in;

import com.demodd.application.patient.patientcontact.dto.PatientContactResponse;

import java.util.List;
import java.util.UUID;

public interface GetPatientContactUseCase {

    PatientContactResponse getById(UUID id);

    List<PatientContactResponse> getAll();
}
