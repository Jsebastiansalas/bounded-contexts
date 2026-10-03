package com.demodd.domain.clinical.diagnosticsystem.exception;

import com.demodd.domain.common.DomainException;
import com.demodd.domain.clinical.diagnosticsystem.model.valueobject.DiagnosticSystemId;

public class DiagnosticSystemNotFoundException extends DomainException {

    public DiagnosticSystemNotFoundException(DiagnosticSystemId id) {
        super("No se encontro la entidad DiagnosticSystem con identificador: " + id.value());
    }

    public DiagnosticSystemNotFoundException(String message) {
        super(message);
    }
}
