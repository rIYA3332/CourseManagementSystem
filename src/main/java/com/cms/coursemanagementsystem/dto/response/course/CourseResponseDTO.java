package com.cms.coursemanagementsystem.dto.response.course;

import java.util.Set;

public record CourseResponseDTO(
        Long id,
        String courseName,
        String description,
        int durationInWeeks,

        Set<Long> enrolledStudentIds
) {}