package com.demodd.domain.clinical.consenttype.port.repository;

import com.demodd.domain.clinical.consenttype.model.aggregate.ConsentType;
import com.demodd.domain.clinical.consenttype.model.valueobject.ConsentTypeId;

import java.util.List;
import java.util.Optional;

public interface ConsentTypeRepositoryPort {

    ConsentType save(ConsentType entity);

    Optional<ConsentType> findById(ConsentTypeId id);

    List<ConsentType> findAll();

    void deleteById(ConsentTypeId id);

    boolean existsById(ConsentTypeId id);
}
