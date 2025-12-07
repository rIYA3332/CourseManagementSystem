package com.cms.coursemanagementsystem.dto.response.student;

import java.util.Set; // Import Set

public record StudentResponseDTO(
        Long id,
        String fullName,
        String email,
        Set<Long> enrolledCourseIds
) {}