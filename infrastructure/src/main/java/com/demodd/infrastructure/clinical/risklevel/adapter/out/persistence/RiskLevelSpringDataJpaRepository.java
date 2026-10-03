package com.demodd.infrastructure.clinical.risklevel.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RiskLevelSpringDataJpaRepository extends JpaRepository<RiskLevelJpaEntity, UUID> {
}
