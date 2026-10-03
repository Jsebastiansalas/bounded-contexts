package com.demodd.domain.geography.documenttype.exception;

import com.demodd.domain.common.DomainException;

public class DocumentTypeAlreadyExistsException extends DomainException {

    public DocumentTypeAlreadyExistsException(String identifier) {
        super("Ya existe un registro de DocumentType con identificador: " + identifier);
    }
}
