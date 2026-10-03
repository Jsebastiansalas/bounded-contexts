package com.demodd.domain.clinical.medicationroute.exception;

import com.demodd.domain.common.DomainException;
import com.demodd.domain.clinical.medicationroute.model.valueobject.MedicationRouteId;

public class MedicationRouteNotFoundException extends DomainException {

    public MedicationRouteNotFoundException(MedicationRouteId id) {
        super("No se encontro la entidad MedicationRoute con identificador: " + id.value());
    }

    public MedicationRouteNotFoundException(String message) {
        super(message);
    }
}
