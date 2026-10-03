package com.demodd.domain.patient.patientallergy.port.repository;

import com.demodd.domain.patient.patientallergy.model.aggregate.PatientAllergy;
import com.demodd.domain.patient.patientallergy.model.valueobject.PatientAllergyId;

import java.util.List;
import java.util.Optional;

public interface PatientAllergyRepositoryPort {

    PatientAllergy save(PatientAllergy entity);

    Optional<PatientAllergy> findById(PatientAllergyId id);

    List<PatientAllergy> findAll();

    void deleteById(PatientAllergyId id);

    boolean existsById(PatientAllergyId id);
}
