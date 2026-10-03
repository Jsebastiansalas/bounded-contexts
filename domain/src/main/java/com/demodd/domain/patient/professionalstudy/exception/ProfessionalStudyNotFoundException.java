package com.demodd.domain.patient.professionalstudy.exception;

import com.demodd.domain.common.DomainException;
import com.demodd.domain.patient.professionalstudy.model.valueobject.ProfessionalStudyId;

public class ProfessionalStudyNotFoundException extends DomainException {

    public ProfessionalStudyNotFoundException(ProfessionalStudyId id) {
        super("No se encontro la entidad ProfessionalStudy con identificador: " + id.value());
    }

    public ProfessionalStudyNotFoundException(String message) {
        super(message);
    }
}
