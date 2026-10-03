package com.demodd.domain.chat.priority.port.repository;

import com.demodd.domain.chat.priority.model.aggregate.Priority;
import com.demodd.domain.chat.priority.model.valueobject.PriorityId;

import java.util.List;
import java.util.Optional;

public interface PriorityRepositoryPort {

    Priority save(Priority entity);

    Optional<Priority> findById(PriorityId id);

    List<Priority> findAll();

    void deleteById(PriorityId id);

    boolean existsById(PriorityId id);
}
