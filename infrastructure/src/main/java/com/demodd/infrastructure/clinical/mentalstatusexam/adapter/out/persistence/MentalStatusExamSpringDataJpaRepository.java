package com.demodd.infrastructure.clinical.mentalstatusexam.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MentalStatusExamSpringDataJpaRepository extends JpaRepository<MentalStatusExamJpaEntity, UUID> {
}
