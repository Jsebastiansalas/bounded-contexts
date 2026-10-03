package com.demodd.infrastructure.geography.country.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CountrySpringDataJpaRepository extends JpaRepository<CountryJpaEntity, UUID> {
}
