package com.demodd.domain.clinical.mentalstatusexam.exception;

import com.demodd.domain.common.DomainException;

public class MentalStatusExamAlreadyExistsException extends DomainException {

    public MentalStatusExamAlreadyExistsException(String identifier) {
        super("Ya existe un registro de MentalStatusExam con identificador: " + identifier);
    }
}
