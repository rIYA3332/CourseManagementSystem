package com.cms.coursemanagementsystem.service.impl;

import com.cms.coursemanagementsystem.dto.request.teacher.CreateTeacherDTO;
import com.cms.coursemanagementsystem.dto.response.teacher.TeacherResponseDTO;
import com.cms.coursemanagementsystem.entity.Course;
import com.cms.coursemanagementsystem.entity.Teacher;
import com.cms.coursemanagementsystem.mapper.TeacherMapper;
import com.cms.coursemanagementsystem.repository.CourseRepository;
import com.cms.coursemanagementsystem.repository.TeacherRepository;
import com.cms.coursemanagementsystem.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public TeacherResponseDTO createTeacher(CreateTeacherDTO dto) {
        Course course = courseRepository.findById(dto.courseId())
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + dto.courseId()));

        Teacher teacher = teacherMapper.toEntity(dto);
        teacher.setCourse(course);

        Teacher savedTeacher = teacherRepository.save(teacher);
        return teacherMapper.toDTO(savedTeacher);
    }

    @Override
    public List<TeacherResponseDTO> getAllTeachers() {
        return teacherRepository.findAll()
                .stream()
                .map(teacherMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TeacherResponseDTO getTeacherById(Long id) {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher not found with id: " + id));
        return teacherMapper.toDTO(teacher);
    }

    @Override
    public TeacherResponseDTO updateTeacher(Long id, CreateTeacherDTO dto) {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher not found with id: " + id));

        Course course = courseRepository.findById(dto.courseId())
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + dto.courseId()));

        teacher.setFullName(dto.fullName());
        teacher.setEmail(dto.email());
        teacher.setCourse(course);

        Teacher updatedTeacher = teacherRepository.save(teacher);
        return teacherMapper.toDTO(updatedTeacher);
    }

    @Override
    public String deleteTeacher(Long id) {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher not found with id: " + id));

        teacherRepository.delete(teacher);
        return "Teacher with id " + id + " deleted successfully!";
    }
}