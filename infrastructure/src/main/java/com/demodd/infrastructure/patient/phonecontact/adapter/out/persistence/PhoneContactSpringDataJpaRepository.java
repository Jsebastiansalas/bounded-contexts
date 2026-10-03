package com.demodd.infrastructure.patient.phonecontact.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PhoneContactSpringDataJpaRepository extends JpaRepository<PhoneContactJpaEntity, UUID> {
}
