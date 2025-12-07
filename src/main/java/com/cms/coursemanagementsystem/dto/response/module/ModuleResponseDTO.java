package com.cms.coursemanagementsystem.dto.response.module;

public record ModuleResponseDTO(
        Long id,
        String moduleName,
        String content,
        Long courseId // To show which course it belongs to
) {}