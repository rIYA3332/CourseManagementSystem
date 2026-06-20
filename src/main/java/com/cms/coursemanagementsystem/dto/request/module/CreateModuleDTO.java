package com.cms.coursemanagementsystem.dto.request.module;

import jakarta.validation.constraints.NotBlank;

public record CreateModuleDTO(
        @NotBlank(message = "Module Name is required")
        String moduleName,

        @NotBlank(message = "Content is required")
        String content,

        Long courseId // To link the module to a course
) {}