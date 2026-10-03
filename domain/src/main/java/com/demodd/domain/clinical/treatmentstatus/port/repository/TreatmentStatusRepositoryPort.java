package com.demodd.domain.clinical.treatmentstatus.port.repository;

import com.demodd.domain.clinical.treatmentstatus.model.aggregate.TreatmentStatus;
import com.demodd.domain.clinical.treatmentstatus.model.valueobject.TreatmentStatusId;

import java.util.List;
import java.util.Optional;

public interface TreatmentStatusRepositoryPort {

    TreatmentStatus save(TreatmentStatus entity);

    Optional<TreatmentStatus> findById(TreatmentStatusId id);

    List<TreatmentStatus> findAll();

    void deleteById(TreatmentStatusId id);

    boolean existsById(TreatmentStatusId id);
}
