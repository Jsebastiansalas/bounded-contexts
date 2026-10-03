package com.demodd.domain.chat.sendertype.port.repository;

import com.demodd.domain.chat.sendertype.model.aggregate.SenderType;
import com.demodd.domain.chat.sendertype.model.valueobject.SenderTypeId;

import java.util.List;
import java.util.Optional;

public interface SenderTypeRepositoryPort {

    SenderType save(SenderType entity);

    Optional<SenderType> findById(SenderTypeId id);

    List<SenderType> findAll();

    void deleteById(SenderTypeId id);

    boolean existsById(SenderTypeId id);
}
