package com.cms.coursemanagementsystem.service;

import com.cms.coursemanagementsystem.dto.request.course.CreateCourseDTO;
import com.cms.coursemanagementsystem.dto.response.course.CourseResponseDTO;

import java.util.List;

public interface CourseService {

    CourseResponseDTO createCourse(CreateCourseDTO courseDTO);

    List<CourseResponseDTO> getAllCourses();

    CourseResponseDTO getCourseById(Long id);

    CourseResponseDTO updateCourse(Long id, CreateCourseDTO courseDTO);

    String deleteCourse(Long id);
}
