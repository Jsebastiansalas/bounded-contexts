package com.demodd.domain.clinical.treatmentplan.port.repository;

import com.demodd.domain.clinical.treatmentplan.model.aggregate.TreatmentPlan;
import com.demodd.domain.clinical.treatmentplan.model.valueobject.TreatmentPlanId;

import java.util.List;
import java.util.Optional;

public interface TreatmentPlanRepositoryPort {

    TreatmentPlan save(TreatmentPlan entity);

    Optional<TreatmentPlan> findById(TreatmentPlanId id);

    List<TreatmentPlan> findAll();

    void deleteById(TreatmentPlanId id);

    boolean existsById(TreatmentPlanId id);
}
