package com.demodd.domain.geography.relationshiptype.exception;

import com.demodd.domain.common.DomainException;

public class RelationshipTypeAlreadyExistsException extends DomainException {

    public RelationshipTypeAlreadyExistsException(String identifier) {
        super("Ya existe un registro de RelationshipType con identificador: " + identifier);
    }
}
