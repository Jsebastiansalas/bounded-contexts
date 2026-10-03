package com.demodd.domain.clinical.risklevel.exception;

import com.demodd.domain.common.DomainException;

public class RiskLevelAlreadyExistsException extends DomainException {

    public RiskLevelAlreadyExistsException(String identifier) {
        super("Ya existe un registro de RiskLevel con identificador: " + identifier);
    }
}
