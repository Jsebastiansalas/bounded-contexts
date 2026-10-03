package com.demodd.domain.chat.airunstatus.port.repository;

import com.demodd.domain.chat.airunstatus.model.aggregate.AiRunStatus;
import com.demodd.domain.chat.airunstatus.model.valueobject.AiRunStatusId;

import java.util.List;
import java.util.Optional;

public interface AiRunStatusRepositoryPort {

    AiRunStatus save(AiRunStatus entity);

    Optional<AiRunStatus> findById(AiRunStatusId id);

    List<AiRunStatus> findAll();

    void deleteById(AiRunStatusId id);

    boolean existsById(AiRunStatusId id);
}
