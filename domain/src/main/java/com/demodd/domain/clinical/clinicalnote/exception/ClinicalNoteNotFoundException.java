package com.demodd.domain.clinical.clinicalnote.exception;

import com.demodd.domain.common.DomainException;
import com.demodd.domain.clinical.clinicalnote.model.valueobject.ClinicalNoteId;

public class ClinicalNoteNotFoundException extends DomainException {

    public ClinicalNoteNotFoundException(ClinicalNoteId id) {
        super("No se encontro la entidad ClinicalNote con identificador: " + id.value());
    }

    public ClinicalNoteNotFoundException(String message) {
        super(message);
    }
}
