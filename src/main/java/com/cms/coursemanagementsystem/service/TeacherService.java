package com.cms.coursemanagementsystem.service;

import com.cms.coursemanagementsystem.dto.request.teacher.CreateTeacherDTO;
import com.cms.coursemanagementsystem.dto.response.teacher.TeacherResponseDTO;

import java.util.List;

public interface TeacherService {

    TeacherResponseDTO createTeacher(CreateTeacherDTO dto);

    List<TeacherResponseDTO> getAllTeachers();

    TeacherResponseDTO getTeacherById(Long id);

    TeacherResponseDTO updateTeacher(Long id, CreateTeacherDTO dto);

    String deleteTeacher(Long id);
}
