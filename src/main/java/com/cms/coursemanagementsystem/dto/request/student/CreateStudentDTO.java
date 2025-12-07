package com.cms.coursemanagementsystem.dto.request.student;

public record CreateStudentDTO(
        String fullName,
        String email
        // Enrollment will be handled in a separate method/controller
) {}