package com.cms.coursemanagementsystem.dto.request.module;

public record CreateModuleDTO(
        String moduleName,
        String content,
        Long courseId // To link the module to a course
) {}