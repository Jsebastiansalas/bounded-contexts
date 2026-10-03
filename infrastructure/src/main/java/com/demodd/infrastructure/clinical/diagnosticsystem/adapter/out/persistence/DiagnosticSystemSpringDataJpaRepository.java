package com.demodd.infrastructure.clinical.diagnosticsystem.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DiagnosticSystemSpringDataJpaRepository extends JpaRepository<DiagnosticSystemJpaEntity, UUID> {
}
