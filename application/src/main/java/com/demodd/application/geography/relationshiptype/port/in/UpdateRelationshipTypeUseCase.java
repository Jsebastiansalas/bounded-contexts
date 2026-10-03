package com.demodd.application.geography.relationshiptype.port.in;

import com.demodd.application.geography.relationshiptype.dto.RelationshipTypeResponse;

import java.util.UUID;

public interface UpdateRelationshipTypeUseCase {

    RelationshipTypeResponse execute(UUID id, String name, String status);
}
