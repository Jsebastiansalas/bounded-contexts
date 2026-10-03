package com.demodd.infrastructure.chat.messagetype.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MessageTypeSpringDataJpaRepository extends JpaRepository<MessageTypeJpaEntity, UUID> {
}
