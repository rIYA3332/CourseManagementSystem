package com.cms.coursemanagementsystem.service.impl;

import com.cms.coursemanagementsystem.dto.request.course.CreateCourseDTO;
import com.cms.coursemanagementsystem.dto.response.course.CourseResponseDTO;
import com.cms.coursemanagementsystem.entity.Course;

import com.cms.coursemanagementsystem.mapper.CourseMapper;
import com.cms.coursemanagementsystem.repository.CourseRepository;
import com.cms.coursemanagementsystem.service.CourseService;
import com.cms.coursemanagementsystem.exception.ResourceNotFoundException;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

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
    @Transactional // Required for the custom query to work within a transaction
    public List<CourseResponseDTO> getAllCourses() {
        // CHANGED: Use the custom repository method
        return courseRepository.findAllWithStudents()
                .stream()
                .map(courseMapper::toDTO)
                .collect(Collectors.toList());
    }


    @Override
    @Transactional // Required for the custom query to work within a transaction
    public CourseResponseDTO getCourseById(Long id) {
        // CHANGED: Use the custom repository method
        Course course = courseRepository.findByIdWithStudents(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course", "id", id));
        return courseMapper.toDTO(course);
    }
    //

    @Override
    public CourseResponseDTO updateCourse(Long id, CreateCourseDTO courseDTO) {
        Course course = courseRepository.findById(id)

                .orElseThrow(() -> new ResourceNotFoundException("Course", "id", id));

        course.setCourseName(courseDTO.courseName());
        course.setDescription(courseDTO.description());
        course.setDurationInWeeks(courseDTO.durationInWeeks());

        Course updatedCourse = courseRepository.save(course);
        return courseMapper.toDTO(updatedCourse);
    }

    @Override
    public String deleteCourse(Long id) {
        Course course = courseRepository.findById(id)

                .orElseThrow(() -> new ResourceNotFoundException("Course", "id", id));

        courseRepository.delete(course);
        return "Course with ID " + id + " deleted successfully!";
    }
}