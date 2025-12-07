package com.cms.coursemanagementsystem.controller;

import com.cms.coursemanagementsystem.dto.request.teacher.CreateTeacherDTO;
import com.cms.coursemanagementsystem.dto.response.teacher.TeacherResponseDTO;
import com.cms.coursemanagementsystem.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @PostMapping
    public TeacherResponseDTO createTeacher(@RequestBody CreateTeacherDTO dto) {
        return teacherService.createTeacher(dto);
    }

    @GetMapping
    public List<TeacherResponseDTO> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

    @GetMapping("/{id}")
    public TeacherResponseDTO getTeacherById(@PathVariable Long id) {
        return teacherService.getTeacherById(id);
    }

    @PutMapping("/{id}")
    public TeacherResponseDTO updateTeacher(@PathVariable Long id, @RequestBody CreateTeacherDTO dto) {
        return teacherService.updateTeacher(id, dto);
    }

    @DeleteMapping("/{id}")
    public String deleteTeacher(@PathVariable Long id) {
        return teacherService.deleteTeacher(id);
    }
}
