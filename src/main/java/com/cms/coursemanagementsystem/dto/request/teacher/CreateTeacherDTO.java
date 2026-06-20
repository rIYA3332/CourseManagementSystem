package com.cms.coursemanagementsystem.dto.request.teacher;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;

public record CreateTeacherDTO(
        @NotBlank(message = "Name is required.")
        String fullName,

        @Email(message = "Email should be in proper format.")
        String email,

        Long courseId
) {}
