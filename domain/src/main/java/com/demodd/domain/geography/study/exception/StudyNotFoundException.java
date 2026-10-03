package com.demodd.domain.geography.study.exception;

import com.demodd.domain.common.DomainException;
import com.demodd.domain.geography.study.model.valueobject.StudyId;

public class StudyNotFoundException extends DomainException {

    public StudyNotFoundException(StudyId id) {
        super("No se encontro la entidad Study con identificador: " + id.value());
    }

    public StudyNotFoundException(String message) {
        super(message);
    }
}
