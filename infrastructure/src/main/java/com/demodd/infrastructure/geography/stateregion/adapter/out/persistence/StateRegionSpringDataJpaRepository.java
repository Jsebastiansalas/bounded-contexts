package com.demodd.infrastructure.geography.stateregion.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StateRegionSpringDataJpaRepository extends JpaRepository<StateRegionJpaEntity, UUID> {
}
