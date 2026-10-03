package com.demodd.domain.geography.relationshiptype.exception;

import com.demodd.domain.common.DomainException;
import com.demodd.domain.geography.relationshiptype.model.valueobject.RelationshipTypeId;

public class RelationshipTypeNotFoundException extends DomainException {

    public RelationshipTypeNotFoundException(RelationshipTypeId id) {
        super("No se encontro la entidad RelationshipType con identificador: " + id.value());
    }

    public RelationshipTypeNotFoundException(String message) {
        super(message);
    }
}
