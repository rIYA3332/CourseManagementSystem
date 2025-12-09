package com.cms.coursemanagementsystem.dto.request.course;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateCourseDTO(
        @NotBlank(message = "Course name is required.")
        @Size(min = 3, max = 100, message = "Course name must be between 3 and 100 characters.")
        String courseName,

        @NotBlank(message = "Description is required.")
        String description,

        @Min(value = 1, message = "Duration must be at least 1 week.")
        int durationInWeeks
) {}