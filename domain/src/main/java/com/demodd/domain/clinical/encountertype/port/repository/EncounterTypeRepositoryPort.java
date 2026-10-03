package com.demodd.domain.clinical.encountertype.port.repository;

import com.demodd.domain.clinical.encountertype.model.aggregate.EncounterType;
import com.demodd.domain.clinical.encountertype.model.valueobject.EncounterTypeId;

import java.util.List;
import java.util.Optional;

public interface EncounterTypeRepositoryPort {

    EncounterType save(EncounterType entity);

    Optional<EncounterType> findById(EncounterTypeId id);

    List<EncounterType> findAll();

    void deleteById(EncounterTypeId id);

    boolean existsById(EncounterTypeId id);
}
