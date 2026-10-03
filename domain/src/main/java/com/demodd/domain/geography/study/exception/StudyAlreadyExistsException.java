package com.demodd.domain.geography.study.exception;

import com.demodd.domain.common.DomainException;

public class StudyAlreadyExistsException extends DomainException {

    public StudyAlreadyExistsException(String identifier) {
        super("Ya existe un registro de Study con identificador: " + identifier);
    }
}
