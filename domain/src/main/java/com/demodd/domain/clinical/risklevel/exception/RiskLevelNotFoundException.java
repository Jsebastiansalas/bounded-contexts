package com.demodd.domain.clinical.risklevel.exception;

import com.demodd.domain.common.DomainException;
import com.demodd.domain.clinical.risklevel.model.valueobject.RiskLevelId;

public class RiskLevelNotFoundException extends DomainException {

    public RiskLevelNotFoundException(RiskLevelId id) {
        super("No se encontro la entidad RiskLevel con identificador: " + id.value());
    }

    public RiskLevelNotFoundException(String message) {
        super(message);
    }
}
