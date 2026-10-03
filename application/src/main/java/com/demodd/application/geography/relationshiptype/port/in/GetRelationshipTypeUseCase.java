package com.demodd.application.geography.relationshiptype.port.in;

import com.demodd.application.geography.relationshiptype.dto.RelationshipTypeResponse;

import java.util.List;
import java.util.UUID;

public interface GetRelationshipTypeUseCase {

    RelationshipTypeResponse getById(UUID id);

    List<RelationshipTypeResponse> getAll();
}
