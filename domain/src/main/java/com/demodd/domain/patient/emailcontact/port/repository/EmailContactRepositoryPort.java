package com.demodd.domain.patient.emailcontact.port.repository;

import com.demodd.domain.patient.emailcontact.model.aggregate.EmailContact;
import com.demodd.domain.patient.emailcontact.model.valueobject.EmailContactId;

import java.util.List;
import java.util.Optional;

public interface EmailContactRepositoryPort {

    EmailContact save(EmailContact entity);

    Optional<EmailContact> findById(EmailContactId id);

    List<EmailContact> findAll();

    void deleteById(EmailContactId id);

    boolean existsById(EmailContactId id);
}
