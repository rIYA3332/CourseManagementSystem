package com.cms.coursemanagementsystem.dto.request.course;

public record CreateCourseDTO(
        String courseName,
        String description,
        int durationInWeeks
) {}
