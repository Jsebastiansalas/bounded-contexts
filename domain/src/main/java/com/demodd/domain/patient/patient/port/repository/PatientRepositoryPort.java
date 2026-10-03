package com.demodd.domain.patient.patient.port.repository;

import com.demodd.domain.patient.patient.model.aggregate.Patient;
import com.demodd.domain.patient.patient.model.valueobject.PatientId;

import java.util.List;
import java.util.Optional;

public interface PatientRepositoryPort {

    Patient save(Patient entity);

    Optional<Patient> findById(PatientId id);

    List<Patient> findAll();

    void deleteById(PatientId id);

    boolean existsById(PatientId id);
}
