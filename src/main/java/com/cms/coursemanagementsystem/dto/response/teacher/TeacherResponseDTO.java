package com.cms.coursemanagementsystem.dto.response.teacher;

public record TeacherResponseDTO(
        Long id,
        String fullName,
        String email,
        Long courseId
) {}
