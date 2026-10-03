package com.demodd.domain.clinical.mentalstatusexam.exception;

import com.demodd.domain.common.DomainException;
import com.demodd.domain.clinical.mentalstatusexam.model.valueobject.MentalStatusExamId;

public class MentalStatusExamNotFoundException extends DomainException {

    public MentalStatusExamNotFoundException(MentalStatusExamId id) {
        super("No se encontro la entidad MentalStatusExam con identificador: " + id.value());
    }

    public MentalStatusExamNotFoundException(String message) {
        super(message);
    }
}
