package com.demodd.infrastructure.geography.gender.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GenderSpringDataJpaRepository extends JpaRepository<GenderJpaEntity, UUID> {
}
