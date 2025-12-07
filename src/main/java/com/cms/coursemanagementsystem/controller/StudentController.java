package com.cms.coursemanagementsystem.controller;

import com.cms.coursemanagementsystem.dto.request.student.CreateStudentDTO;
import com.cms.coursemanagementsystem.dto.request.student.StudentCourseDTO; // New import
import com.cms.coursemanagementsystem.dto.response.student.StudentResponseDTO;
import com.cms.coursemanagementsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // ... (Existing CRUD methods remain the same) ...

    @PostMapping
    public StudentResponseDTO createStudent(@RequestBody CreateStudentDTO studentDTO) {
        return studentService.createStudent(studentDTO);
    }

    @GetMapping
    public List<StudentResponseDTO> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public StudentResponseDTO getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @PutMapping("/{id}")
    public StudentResponseDTO updateStudent(@PathVariable Long id, @RequestBody CreateStudentDTO studentDTO) {
        return studentService.updateStudent(id, studentDTO);
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {
        return studentService.deleteStudent(id);
    }

    @PostMapping("/{studentId}/enroll")
    public StudentResponseDTO enrollStudent(@PathVariable Long studentId, @RequestBody StudentCourseDTO dto) {
        return studentService.enrollStudentInCourse(studentId, dto.courseId());
    }
}