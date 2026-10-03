package com.demodd.domain.geography.professionaltype.exception;

import com.demodd.domain.common.DomainException;
import com.demodd.domain.geography.professionaltype.model.valueobject.ProfessionalTypeId;

public class ProfessionalTypeNotFoundException extends DomainException {

    public ProfessionalTypeNotFoundException(ProfessionalTypeId id) {
        super("No se encontro la entidad ProfessionalType con identificador: " + id.value());
    }

    public ProfessionalTypeNotFoundException(String message) {
        super(message);
    }
}
