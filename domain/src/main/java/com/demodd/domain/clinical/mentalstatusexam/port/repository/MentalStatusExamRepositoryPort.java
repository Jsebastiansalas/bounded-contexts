package com.demodd.domain.clinical.mentalstatusexam.port.repository;

import com.demodd.domain.clinical.mentalstatusexam.model.aggregate.MentalStatusExam;
import com.demodd.domain.clinical.mentalstatusexam.model.valueobject.MentalStatusExamId;

import java.util.List;
import java.util.Optional;

public interface MentalStatusExamRepositoryPort {

    MentalStatusExam save(MentalStatusExam entity);

    Optional<MentalStatusExam> findById(MentalStatusExamId id);

    List<MentalStatusExam> findAll();

    void deleteById(MentalStatusExamId id);

    boolean existsById(MentalStatusExamId id);
}
