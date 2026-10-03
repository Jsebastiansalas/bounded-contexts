package com.demodd.domain.patient.professional.exception;

import com.demodd.domain.common.DomainException;
import com.demodd.domain.patient.professional.model.valueobject.ProfessionalId;

public class ProfessionalNotFoundException extends DomainException {

    public ProfessionalNotFoundException(ProfessionalId id) {
        super("No se encontro la entidad Professional con identificador: " + id.value());
    }

    public ProfessionalNotFoundException(String message) {
        super(message);
    }
}
