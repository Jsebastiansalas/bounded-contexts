package com.demodd.domain.patient.professional.port.repository;

import com.demodd.domain.patient.professional.model.aggregate.Professional;
import com.demodd.domain.patient.professional.model.valueobject.ProfessionalId;

import java.util.List;
import java.util.Optional;

public interface ProfessionalRepositoryPort {

    Professional save(Professional entity);

    Optional<Professional> findById(ProfessionalId id);

    List<Professional> findAll();

    void deleteById(ProfessionalId id);

    boolean existsById(ProfessionalId id);
}
