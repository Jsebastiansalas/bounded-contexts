package com.demodd.domain.clinical.clinicalnote.exception;

import com.demodd.domain.common.DomainException;

public class ClinicalNoteAlreadyExistsException extends DomainException {

    public ClinicalNoteAlreadyExistsException(String identifier) {
        super("Ya existe un registro de ClinicalNote con identificador: " + identifier);
    }
}
