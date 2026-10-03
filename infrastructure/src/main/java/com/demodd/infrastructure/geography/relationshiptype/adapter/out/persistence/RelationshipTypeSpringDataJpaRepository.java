package com.demodd.infrastructure.geography.relationshiptype.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RelationshipTypeSpringDataJpaRepository extends JpaRepository<RelationshipTypeJpaEntity, UUID> {
}
