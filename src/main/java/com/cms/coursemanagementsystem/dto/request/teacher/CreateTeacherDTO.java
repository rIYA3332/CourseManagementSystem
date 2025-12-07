package com.cms.coursemanagementsystem.dto.request.teacher;

public record CreateTeacherDTO(
        String fullName,
        String email,
        Long courseId
) {}
