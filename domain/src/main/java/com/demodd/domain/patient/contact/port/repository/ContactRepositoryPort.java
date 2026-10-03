package com.demodd.domain.patient.contact.port.repository;

import com.demodd.domain.patient.contact.model.aggregate.Contact;
import com.demodd.domain.patient.contact.model.valueobject.ContactId;

import java.util.List;
import java.util.Optional;

public interface ContactRepositoryPort {

    Contact save(Contact entity);

    Optional<Contact> findById(ContactId id);

    List<Contact> findAll();

    void deleteById(ContactId id);

    boolean existsById(ContactId id);
}
