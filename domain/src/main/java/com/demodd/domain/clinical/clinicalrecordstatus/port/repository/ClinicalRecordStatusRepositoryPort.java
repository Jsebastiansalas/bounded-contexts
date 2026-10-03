package com.demodd.domain.clinical.clinicalrecordstatus.port.repository;

import com.demodd.domain.clinical.clinicalrecordstatus.model.aggregate.ClinicalRecordStatus;
import com.demodd.domain.clinical.clinicalrecordstatus.model.valueobject.ClinicalRecordStatusId;

import java.util.List;
import java.util.Optional;

public interface ClinicalRecordStatusRepositoryPort {

    ClinicalRecordStatus save(ClinicalRecordStatus entity);

    Optional<ClinicalRecordStatus> findById(ClinicalRecordStatusId id);

    List<ClinicalRecordStatus> findAll();

    void deleteById(ClinicalRecordStatusId id);

    boolean existsById(ClinicalRecordStatusId id);
}
