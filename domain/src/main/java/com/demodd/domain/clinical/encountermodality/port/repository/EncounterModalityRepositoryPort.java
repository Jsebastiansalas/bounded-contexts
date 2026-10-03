package com.demodd.domain.clinical.encountermodality.port.repository;

import com.demodd.domain.clinical.encountermodality.model.aggregate.EncounterModality;
import com.demodd.domain.clinical.encountermodality.model.valueobject.EncounterModalityId;

import java.util.List;
import java.util.Optional;

public interface EncounterModalityRepositoryPort {

    EncounterModality save(EncounterModality entity);

    Optional<EncounterModality> findById(EncounterModalityId id);

    List<EncounterModality> findAll();

    void deleteById(EncounterModalityId id);

    boolean existsById(EncounterModalityId id);
}
