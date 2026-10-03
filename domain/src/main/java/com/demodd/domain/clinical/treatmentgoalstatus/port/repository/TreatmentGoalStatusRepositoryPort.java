package com.demodd.domain.clinical.treatmentgoalstatus.port.repository;

import com.demodd.domain.clinical.treatmentgoalstatus.model.aggregate.TreatmentGoalStatus;
import com.demodd.domain.clinical.treatmentgoalstatus.model.valueobject.TreatmentGoalStatusId;

import java.util.List;
import java.util.Optional;

public interface TreatmentGoalStatusRepositoryPort {

    TreatmentGoalStatus save(TreatmentGoalStatus entity);

    Optional<TreatmentGoalStatus> findById(TreatmentGoalStatusId id);

    List<TreatmentGoalStatus> findAll();

    void deleteById(TreatmentGoalStatusId id);

    boolean existsById(TreatmentGoalStatusId id);
}
