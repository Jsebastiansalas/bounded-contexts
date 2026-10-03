package com.demodd.infrastructure.geography.documenttype.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DocumentTypeSpringDataJpaRepository extends JpaRepository<DocumentTypeJpaEntity, UUID> {
}
