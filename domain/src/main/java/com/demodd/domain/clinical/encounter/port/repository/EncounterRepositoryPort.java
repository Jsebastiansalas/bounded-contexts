package com.demodd.domain.clinical.encounter.port.repository;

import com.demodd.domain.clinical.encounter.model.aggregate.Encounter;
import com.demodd.domain.clinical.encounter.model.valueobject.EncounterId;

import java.util.List;
import java.util.Optional;

public interface EncounterRepositoryPort {

    Encounter save(Encounter entity);

    Optional<Encounter> findById(EncounterId id);

    List<Encounter> findAll();

    void deleteById(EncounterId id);

    boolean existsById(EncounterId id);
}
