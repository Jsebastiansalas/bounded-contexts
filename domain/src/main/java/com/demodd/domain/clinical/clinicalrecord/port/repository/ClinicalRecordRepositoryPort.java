package com.demodd.domain.clinical.clinicalrecord.port.repository;

import com.demodd.domain.clinical.clinicalrecord.model.aggregate.ClinicalRecord;
import com.demodd.domain.clinical.clinicalrecord.model.valueobject.ClinicalRecordId;

import java.util.List;
import java.util.Optional;

public interface ClinicalRecordRepositoryPort {

    ClinicalRecord save(ClinicalRecord entity);

    Optional<ClinicalRecord> findById(ClinicalRecordId id);

    List<ClinicalRecord> findAll();

    void deleteById(ClinicalRecordId id);

    boolean existsById(ClinicalRecordId id);
}
