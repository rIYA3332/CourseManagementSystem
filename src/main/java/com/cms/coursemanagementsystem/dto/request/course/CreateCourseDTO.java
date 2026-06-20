package com.cms.coursemanagementsystem.dto.request.course;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record CreateCourseDTO(
        @NotBlank(message = "Course name is required.")
        String courseName,

        @NotBlank(message = "Description is required.")
        String description,

        @Min(value = 1, message = "Duration must be at least 1 week.")
        int durationInWeeks
) {}