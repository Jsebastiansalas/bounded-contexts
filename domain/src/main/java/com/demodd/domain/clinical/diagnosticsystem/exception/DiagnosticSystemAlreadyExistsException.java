package com.demodd.domain.clinical.diagnosticsystem.exception;

import com.demodd.domain.common.DomainException;

public class DiagnosticSystemAlreadyExistsException extends DomainException {

    public DiagnosticSystemAlreadyExistsException(String identifier) {
        super("Ya existe un registro de DiagnosticSystem con identificador: " + identifier);
    }
}
