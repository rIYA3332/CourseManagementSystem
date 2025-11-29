package com.cms.coursemanagementsystem.dto.response.course;

public record CourseResponseDTO(
        Long id,
        String courseName,
        String description,
        int durationInWeeks
) {}
