package com.demodd.domain.geography.documenttype.exception;

import com.demodd.domain.common.DomainException;
import com.demodd.domain.geography.documenttype.model.valueobject.DocumentTypeId;

public class DocumentTypeNotFoundException extends DomainException {

    public DocumentTypeNotFoundException(DocumentTypeId id) {
        super("No se encontro la entidad DocumentType con identificador: " + id.value());
    }

    public DocumentTypeNotFoundException(String message) {
        super(message);
    }
}
