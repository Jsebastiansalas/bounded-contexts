package com.demodd.domain.chat.providermodelai.port.repository;

import com.demodd.domain.chat.providermodelai.model.aggregate.ProviderModelAi;
import com.demodd.domain.chat.providermodelai.model.valueobject.ProviderModelAiId;

import java.util.List;
import java.util.Optional;

public interface ProviderModelAiRepositoryPort {

    ProviderModelAi save(ProviderModelAi entity);

    Optional<ProviderModelAi> findById(ProviderModelAiId id);

    List<ProviderModelAi> findAll();

    void deleteById(ProviderModelAiId id);

    boolean existsById(ProviderModelAiId id);
}
