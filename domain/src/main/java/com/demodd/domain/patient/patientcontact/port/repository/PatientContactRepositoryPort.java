package com.demodd.domain.patient.patientcontact.port.repository;

import com.demodd.domain.patient.patientcontact.model.aggregate.PatientContact;
import com.demodd.domain.patient.patientcontact.model.valueobject.PatientContactId;

import java.util.List;
import java.util.Optional;

public interface PatientContactRepositoryPort {

    PatientContact save(PatientContact entity);

    Optional<PatientContact> findById(PatientContactId id);

    List<PatientContact> findAll();

    void deleteById(PatientContactId id);

    boolean existsById(PatientContactId id);
}
