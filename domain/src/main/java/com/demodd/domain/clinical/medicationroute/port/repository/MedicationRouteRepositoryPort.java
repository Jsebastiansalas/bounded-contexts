package com.demodd.domain.clinical.medicationroute.port.repository;

import com.demodd.domain.clinical.medicationroute.model.aggregate.MedicationRoute;
import com.demodd.domain.clinical.medicationroute.model.valueobject.MedicationRouteId;

import java.util.List;
import java.util.Optional;

public interface MedicationRouteRepositoryPort {

    MedicationRoute save(MedicationRoute entity);

    Optional<MedicationRoute> findById(MedicationRouteId id);

    List<MedicationRoute> findAll();

    void deleteById(MedicationRouteId id);

    boolean existsById(MedicationRouteId id);
}
