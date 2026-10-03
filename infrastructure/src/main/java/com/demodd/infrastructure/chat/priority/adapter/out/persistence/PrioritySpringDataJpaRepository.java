package com.demodd.infrastructure.chat.priority.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PrioritySpringDataJpaRepository extends JpaRepository<PriorityJpaEntity, UUID> {
}
