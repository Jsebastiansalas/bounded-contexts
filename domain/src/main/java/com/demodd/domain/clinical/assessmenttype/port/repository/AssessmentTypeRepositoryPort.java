package com.demodd.domain.clinical.assessmenttype.port.repository;

import com.demodd.domain.clinical.assessmenttype.model.aggregate.AssessmentType;
import com.demodd.domain.clinical.assessmenttype.model.valueobject.AssessmentTypeId;

import java.util.List;
import java.util.Optional;

public interface AssessmentTypeRepositoryPort {

    AssessmentType save(AssessmentType entity);

    Optional<AssessmentType> findById(AssessmentTypeId id);

    List<AssessmentType> findAll();

    void deleteById(AssessmentTypeId id);

    boolean existsById(AssessmentTypeId id);
}
