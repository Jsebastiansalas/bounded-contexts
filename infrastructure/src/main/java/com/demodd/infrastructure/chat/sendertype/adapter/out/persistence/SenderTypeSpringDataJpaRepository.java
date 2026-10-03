package com.demodd.infrastructure.chat.sendertype.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SenderTypeSpringDataJpaRepository extends JpaRepository<SenderTypeJpaEntity, UUID> {
}
