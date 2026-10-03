package com.demodd.application.geography.relationshiptype.port.in;

import com.demodd.application.geography.relationshiptype.dto.RelationshipTypeResponse;

public interface CreateRelationshipTypeUseCase {

    RelationshipTypeResponse execute(String name);
}
