package com.demodd.infrastructure.chat.providermodelai.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProviderModelAiSpringDataJpaRepository extends JpaRepository<ProviderModelAiJpaEntity, UUID> {
}
