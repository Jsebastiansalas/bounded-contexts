package com.demodd.infrastructure.chat.chatairunmetric.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ChatAiRunMetricSpringDataJpaRepository extends JpaRepository<ChatAiRunMetricJpaEntity, UUID> {
}
