package com.cms.coursemanagementsystem.dto.request.student;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CreateStudentDTO(
        @NotBlank(message = "Full Name is required")
        String fullName,
        @NotBlank(message = "Email is required")
        @Email(message = "Email format is invalid")
        String email
        // Enrollment will be handled in a separate method/controller
) {}