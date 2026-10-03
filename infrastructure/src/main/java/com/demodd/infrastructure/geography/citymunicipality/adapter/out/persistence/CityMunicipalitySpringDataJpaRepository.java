package com.demodd.infrastructure.geography.citymunicipality.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CityMunicipalitySpringDataJpaRepository extends JpaRepository<CityMunicipalityJpaEntity, UUID> {
}
