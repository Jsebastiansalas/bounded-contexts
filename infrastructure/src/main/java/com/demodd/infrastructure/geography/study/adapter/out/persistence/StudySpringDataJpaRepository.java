package com.demodd.infrastructure.geography.study.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StudySpringDataJpaRepository extends JpaRepository<StudyJpaEntity, UUID> {
}
