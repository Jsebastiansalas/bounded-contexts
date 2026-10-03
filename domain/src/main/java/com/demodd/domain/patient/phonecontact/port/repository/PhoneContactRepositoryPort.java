package com.demodd.domain.patient.phonecontact.port.repository;

import com.demodd.domain.patient.phonecontact.model.aggregate.PhoneContact;
import com.demodd.domain.patient.phonecontact.model.valueobject.PhoneContactId;

import java.util.List;
import java.util.Optional;

public interface PhoneContactRepositoryPort {

    PhoneContact save(PhoneContact entity);

    Optional<PhoneContact> findById(PhoneContactId id);

    List<PhoneContact> findAll();

    void deleteById(PhoneContactId id);

    boolean existsById(PhoneContactId id);
}
