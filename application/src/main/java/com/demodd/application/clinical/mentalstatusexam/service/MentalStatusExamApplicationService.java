package com.demodd.application.clinical.mentalstatusexam.service;

import com.demodd.application.clinical.mentalstatusexam.dto.MentalStatusExamResponse;
import com.demodd.application.clinical.mentalstatusexam.port.in.CreateMentalStatusExamUseCase;
import com.demodd.application.clinical.mentalstatusexam.port.in.DeleteMentalStatusExamUseCase;
import com.demodd.application.clinical.mentalstatusexam.port.in.GetMentalStatusExamUseCase;
import com.demodd.application.clinical.mentalstatusexam.port.in.UpdateMentalStatusExamUseCase;
import com.demodd.domain.clinical.mentalstatusexam.exception.MentalStatusExamNotFoundException;
import com.demodd.domain.clinical.mentalstatusexam.model.aggregate.MentalStatusExam;
import com.demodd.domain.clinical.mentalstatusexam.model.valueobject.MentalStatusExamId;
import com.demodd.domain.clinical.mentalstatusexam.model.valueobject.MentalStatusExamName;
import com.demodd.domain.clinical.mentalstatusexam.model.valueobject.MentalStatusExamStatus;
import com.demodd.domain.clinical.mentalstatusexam.port.repository.MentalStatusExamRepositoryPort;

import java.util.List;
import java.util.UUID;

public class MentalStatusExamApplicationService implements
        CreateMentalStatusExamUseCase,
        UpdateMentalStatusExamUseCase,
        GetMentalStatusExamUseCase,
        DeleteMentalStatusExamUseCase {

    private final MentalStatusExamRepositoryPort repository;

    public MentalStatusExamApplicationService(MentalStatusExamRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public MentalStatusExamResponse execute(String name) {
        MentalStatusExam entity = MentalStatusExam.create(MentalStatusExamName.of(name));
        MentalStatusExam saved = repository.save(entity);
        return MentalStatusExamResponse.fromDomain(saved);
    }

    @Override
    public MentalStatusExamResponse execute(UUID id, String name, String status) {
        MentalStatusExamId entityId = MentalStatusExamId.of(id);
        MentalStatusExam entity = repository.findById(entityId)
                .orElseThrow(() -> new MentalStatusExamNotFoundException(entityId));

        entity.update(MentalStatusExamName.of(name), MentalStatusExamStatus.of(status));
        MentalStatusExam updated = repository.save(entity);
        return MentalStatusExamResponse.fromDomain(updated);
    }

    @Override
    public MentalStatusExamResponse getById(UUID id) {
        MentalStatusExamId entityId = MentalStatusExamId.of(id);
        return repository.findById(entityId)
                .map(MentalStatusExamResponse::fromDomain)
                .orElseThrow(() -> new MentalStatusExamNotFoundException(entityId));
    }

    @Override
    public List<MentalStatusExamResponse> getAll() {
        return repository.findAll().stream()
                .map(MentalStatusExamResponse::fromDomain)
                .toList();
    }

    @Override
    public void execute(UUID id) {
        MentalStatusExamId entityId = MentalStatusExamId.of(id);
        if (!repository.existsById(entityId)) {
            throw new MentalStatusExamNotFoundException(entityId);
        }
        repository.deleteById(entityId);
    }
}
