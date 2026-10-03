package com.demodd.application.clinical.mentalstatusexam.port.in;

import com.demodd.application.clinical.mentalstatusexam.dto.MentalStatusExamResponse;

import java.util.UUID;

public interface UpdateMentalStatusExamUseCase {

    MentalStatusExamResponse execute(UUID id, String name, String status);
}
