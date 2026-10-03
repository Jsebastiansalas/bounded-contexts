package com.demodd.domain.geography.professionaltype.port.repository;

import com.demodd.domain.geography.professionaltype.model.aggregate.ProfessionalType;
import com.demodd.domain.geography.professionaltype.model.valueobject.ProfessionalTypeId;

import java.util.List;
import java.util.Optional;

public interface ProfessionalTypeRepositoryPort {

    ProfessionalType save(ProfessionalType entity);

    Optional<ProfessionalType> findById(ProfessionalTypeId id);

    List<ProfessionalType> findAll();

    void deleteById(ProfessionalTypeId id);

    boolean existsById(ProfessionalTypeId id);
}
