package com.demodd.domain.patient.professionalstudy.port.repository;

import com.demodd.domain.patient.professionalstudy.model.aggregate.ProfessionalStudy;
import com.demodd.domain.patient.professionalstudy.model.valueobject.ProfessionalStudyId;

import java.util.List;
import java.util.Optional;

public interface ProfessionalStudyRepositoryPort {

    ProfessionalStudy save(ProfessionalStudy entity);

    Optional<ProfessionalStudy> findById(ProfessionalStudyId id);

    List<ProfessionalStudy> findAll();

    void deleteById(ProfessionalStudyId id);

    boolean existsById(ProfessionalStudyId id);
}
