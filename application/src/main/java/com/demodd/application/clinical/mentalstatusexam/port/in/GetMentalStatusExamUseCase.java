package com.demodd.application.clinical.mentalstatusexam.port.in;

import com.demodd.application.clinical.mentalstatusexam.dto.MentalStatusExamResponse;

import java.util.List;
import java.util.UUID;

public interface GetMentalStatusExamUseCase {

    MentalStatusExamResponse getById(UUID id);

    List<MentalStatusExamResponse> getAll();
}
