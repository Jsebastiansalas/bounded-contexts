package com.demodd.application.geography.study.service;

import com.demodd.application.geography.study.dto.StudyResponse;
import com.demodd.application.geography.study.port.in.CreateStudyUseCase;
import com.demodd.application.geography.study.port.in.DeleteStudyUseCase;
import com.demodd.application.geography.study.port.in.GetStudyUseCase;
import com.demodd.application.geography.study.port.in.UpdateStudyUseCase;
import com.demodd.domain.geography.study.exception.StudyNotFoundException;
import com.demodd.domain.geography.study.model.aggregate.Study;
import com.demodd.domain.geography.study.model.valueobject.StudyId;
import com.demodd.domain.geography.study.model.valueobject.StudyName;
import com.demodd.domain.geography.study.model.valueobject.StudyStatus;
import com.demodd.domain.geography.study.port.repository.StudyRepositoryPort;

import java.util.List;
import java.util.UUID;

public class StudyApplicationService implements
        CreateStudyUseCase,
        UpdateStudyUseCase,
        GetStudyUseCase,
        DeleteStudyUseCase {

    private final StudyRepositoryPort repository;

    public StudyApplicationService(StudyRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public StudyResponse execute(String name) {
        Study entity = Study.create(StudyName.of(name));
        Study saved = repository.save(entity);
        return StudyResponse.fromDomain(saved);
    }

    @Override
    public StudyResponse execute(UUID id, String name, String status) {
        StudyId entityId = StudyId.of(id);
        Study entity = repository.findById(entityId)
                .orElseThrow(() -> new StudyNotFoundException(entityId));

        entity.update(StudyName.of(name), StudyStatus.of(status));
        Study updated = repository.save(entity);
        return StudyResponse.fromDomain(updated);
    }

    @Override
    public StudyResponse getById(UUID id) {
        StudyId entityId = StudyId.of(id);
        return repository.findById(entityId)
                .map(StudyResponse::fromDomain)
                .orElseThrow(() -> new StudyNotFoundException(entityId));
    }

    @Override
    public List<StudyResponse> getAll() {
        return repository.findAll().stream()
                .map(StudyResponse::fromDomain)
                .toList();
    }

    @Override
    public void execute(UUID id) {
        StudyId entityId = StudyId.of(id);
        if (!repository.existsById(entityId)) {
            throw new StudyNotFoundException(entityId);
        }
        repository.deleteById(entityId);
    }
}
