package com.cms.coursemanagementsystem.dto.request.program;

import jakarta.validation.constraints.NotBlank;

public record CreateProgramDTO(
        @NotBlank(message = "Program name is required.")
        String programName,

        @NotBlank(message = "Description is required.")
        String description
) {}