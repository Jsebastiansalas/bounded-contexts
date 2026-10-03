package com.demodd.infrastructure.patient.contact.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ContactSpringDataJpaRepository extends JpaRepository<ContactJpaEntity, UUID> {
}
