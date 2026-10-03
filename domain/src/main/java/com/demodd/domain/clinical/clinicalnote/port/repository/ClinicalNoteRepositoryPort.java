package com.demodd.domain.clinical.clinicalnote.port.repository;

import com.demodd.domain.clinical.clinicalnote.model.aggregate.ClinicalNote;
import com.demodd.domain.clinical.clinicalnote.model.valueobject.ClinicalNoteId;

import java.util.List;
import java.util.Optional;

public interface ClinicalNoteRepositoryPort {

    ClinicalNote save(ClinicalNote entity);

    Optional<ClinicalNote> findById(ClinicalNoteId id);

    List<ClinicalNote> findAll();

    void deleteById(ClinicalNoteId id);

    boolean existsById(ClinicalNoteId id);
}
