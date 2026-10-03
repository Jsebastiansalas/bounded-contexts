package com.demodd.domain.geography.gender.port.repository;

import com.demodd.domain.geography.gender.model.aggregate.Gender;
import com.demodd.domain.geography.gender.model.valueobject.GenderId;

import java.util.List;
import java.util.Optional;

public interface GenderRepositoryPort {

    Gender save(Gender entity);

    Optional<Gender> findById(GenderId id);

    List<Gender> findAll();

    void deleteById(GenderId id);

    boolean existsById(GenderId id);
}
