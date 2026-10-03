package com.demodd.application.clinical.mentalstatusexam.port.in;

import com.demodd.application.clinical.mentalstatusexam.dto.MentalStatusExamResponse;

public interface CreateMentalStatusExamUseCase {

    MentalStatusExamResponse execute(String name);
}
