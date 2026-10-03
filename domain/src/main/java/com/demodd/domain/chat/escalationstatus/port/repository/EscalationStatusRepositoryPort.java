package com.demodd.domain.chat.escalationstatus.port.repository;

import com.demodd.domain.chat.escalationstatus.model.aggregate.EscalationStatus;
import com.demodd.domain.chat.escalationstatus.model.valueobject.EscalationStatusId;

import java.util.List;
import java.util.Optional;

public interface EscalationStatusRepositoryPort {

    EscalationStatus save(EscalationStatus entity);

    Optional<EscalationStatus> findById(EscalationStatusId id);

    List<EscalationStatus> findAll();

    void deleteById(EscalationStatusId id);

    boolean existsById(EscalationStatusId id);
}
