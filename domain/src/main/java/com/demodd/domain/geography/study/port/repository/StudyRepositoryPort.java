package com.demodd.domain.geography.study.port.repository;

import com.demodd.domain.geography.study.model.aggregate.Study;
import com.demodd.domain.geography.study.model.valueobject.StudyId;

import java.util.List;
import java.util.Optional;

public interface StudyRepositoryPort {

    Study save(Study entity);

    Optional<Study> findById(StudyId id);

    List<Study> findAll();

    void deleteById(StudyId id);

    boolean existsById(StudyId id);
}
