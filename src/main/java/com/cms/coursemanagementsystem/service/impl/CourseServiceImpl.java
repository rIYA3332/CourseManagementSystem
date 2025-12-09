package com.cms.coursemanagementsystem.service.impl;

import com.cms.coursemanagementsystem.dto.request.course.CreateCourseDTO;
import com.cms.coursemanagementsystem.dto.response.course.CourseResponseDTO;
import com.cms.coursemanagementsystem.entity.Course;
import com.cms.coursemanagementsystem.exception.ApiException;
import com.cms.coursemanagementsystem.mapper.CourseMapper;
import com.cms.coursemanagementsystem.repository.CourseRepository;
import com.cms.coursemanagementsystem.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public CourseResponseDTO createCourse(CreateCourseDTO courseDTO) {

        Course course = courseMapper.toEntity(courseDTO);
        Course savedCourse = courseRepository.save(course);
        return courseMapper.toDTO(savedCourse);
    }

    @Override
    public List<CourseResponseDTO> getAllCourses() {
        return courseRepository.findAll()
                .stream()
                .map(courseMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CourseResponseDTO getCourseById(Long id) {
        Course course = courseRepository.findById(id)
                // Correctly handles 404 Not Found
                .orElseThrow(() -> new ApiException(
                        "Course not found with ID: " + id,
                        HttpStatus.NOT_FOUND)
                );
        return courseMapper.toDTO(course);
    }

    @Override
    public CourseResponseDTO updateCourse(Long id, CreateCourseDTO courseDTO) {
        Course course = courseRepository.findById(id)

                .orElseThrow(() -> new ApiException(
                        "Course not found for update with ID: " + id,
                        HttpStatus.NOT_FOUND)
                );

        course.setCourseName(courseDTO.courseName());
        course.setDescription(courseDTO.description());
        course.setDurationInWeeks(courseDTO.durationInWeeks());

        Course updatedCourse = courseRepository.save(course);
        return courseMapper.toDTO(updatedCourse);
    }

    @Override
    public String deleteCourse(Long id) {
        Course course = courseRepository.findById(id)

                .orElseThrow(() -> new ApiException(
                        "Course not found for deletion with ID: " + id,
                        HttpStatus.NOT_FOUND)
                );

        courseRepository.delete(course);
        return "Course with ID " + id + " deleted successfully!";
    }
}