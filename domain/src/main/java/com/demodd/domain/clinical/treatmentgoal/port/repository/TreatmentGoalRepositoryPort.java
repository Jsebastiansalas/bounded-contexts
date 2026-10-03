package com.demodd.domain.clinical.treatmentgoal.port.repository;

import com.demodd.domain.clinical.treatmentgoal.model.aggregate.TreatmentGoal;
import com.demodd.domain.clinical.treatmentgoal.model.valueobject.TreatmentGoalId;

import java.util.List;
import java.util.Optional;

public interface TreatmentGoalRepositoryPort {

    TreatmentGoal save(TreatmentGoal entity);

    Optional<TreatmentGoal> findById(TreatmentGoalId id);

    List<TreatmentGoal> findAll();

    void deleteById(TreatmentGoalId id);

    boolean existsById(TreatmentGoalId id);
}
