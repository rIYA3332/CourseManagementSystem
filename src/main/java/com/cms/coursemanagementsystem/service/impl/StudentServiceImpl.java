package com.cms.coursemanagementsystem.service.impl;

import com.cms.coursemanagementsystem.dto.request.student.CreateStudentDTO;
import com.cms.coursemanagementsystem.dto.response.student.StudentResponseDTO;
import com.cms.coursemanagementsystem.entity.Course;
import com.cms.coursemanagementsystem.entity.Student;
import com.cms.coursemanagementsystem.exception.ResourceNotFoundException;
import com.cms.coursemanagementsystem.mapper.StudentMapper;
import com.cms.coursemanagementsystem.repository.CourseRepository;
import com.cms.coursemanagementsystem.repository.StudentRepository;
import com.cms.coursemanagementsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; // Import Transactional

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository; // Need this to find the course

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public StudentResponseDTO createStudent(CreateStudentDTO studentDTO) {
        Student student = studentMapper.toEntity(studentDTO);
        Student savedStudent = studentRepository.save(student);
        return studentMapper.toDTO(savedStudent);
    }

    @Override
    public List<StudentResponseDTO> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(studentMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public StudentResponseDTO getStudentById(Long id) {
        // CHANGED: Use findByIdWithCourses and ResourceNotFoundException
        Student student = studentRepository.findByIdWithCourses(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student", "id", id));
        return studentMapper.toDTO(student);
    }

    @Override
    public StudentResponseDTO updateStudent(Long id, CreateStudentDTO studentDTO) {
        // CHANGED: Use ResourceNotFoundException
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student", "id", id));

        student.setFullName(studentDTO.fullName());
        student.setEmail(studentDTO.email());

        Student updatedStudent = studentRepository.save(student);
        return studentMapper.toDTO(updatedStudent);
    }

    @Override
    public String deleteStudent(Long id) {
        // CHANGED: Use ResourceNotFoundException
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student", "id", id));

        studentRepository.delete(student);
        return "Student with ID " + id + " deleted successfully!";
    }


    @Override
    @Transactional
    public StudentResponseDTO enrollStudentInCourse(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + studentId));

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + courseId));


        student.getCourses().add(course);
        course.getStudents().add(student);


        Student updatedStudent = studentRepository.save(student);
        return studentMapper.toDTO(updatedStudent);
    }
}