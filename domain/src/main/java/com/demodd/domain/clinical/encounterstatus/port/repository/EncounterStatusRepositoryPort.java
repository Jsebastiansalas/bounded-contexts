package com.demodd.domain.clinical.encounterstatus.port.repository;

import com.demodd.domain.clinical.encounterstatus.model.aggregate.EncounterStatus;
import com.demodd.domain.clinical.encounterstatus.model.valueobject.EncounterStatusId;

import java.util.List;
import java.util.Optional;

public interface EncounterStatusRepositoryPort {

    EncounterStatus save(EncounterStatus entity);

    Optional<EncounterStatus> findById(EncounterStatusId id);

    List<EncounterStatus> findAll();

    void deleteById(EncounterStatusId id);

    boolean existsById(EncounterStatusId id);
}
