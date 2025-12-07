package com.cms.coursemanagementsystem.service;

import com.cms.coursemanagementsystem.dto.request.student.CreateStudentDTO;
import com.cms.coursemanagementsystem.dto.response.student.StudentResponseDTO;

import java.util.List;

public interface StudentService {

    StudentResponseDTO createStudent(CreateStudentDTO studentDTO);

    List<StudentResponseDTO> getAllStudents();

    StudentResponseDTO getStudentById(Long id);

    StudentResponseDTO updateStudent(Long id, CreateStudentDTO studentDTO);

    StudentResponseDTO enrollStudentInCourse(Long studentId, Long courseId);

    String deleteStudent(Long id);
}