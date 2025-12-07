package com.cms.coursemanagementsystem.mapper;

import com.cms.coursemanagementsystem.dto.request.teacher.CreateTeacherDTO;
import com.cms.coursemanagementsystem.dto.response.teacher.TeacherResponseDTO;
import com.cms.coursemanagementsystem.entity.Teacher;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TeacherMapper {

    TeacherMapper INSTANCE = Mappers.getMapper(TeacherMapper.class);

    // DTO - Entity (Ignore course, it's set in service)
    @Mapping(target = "course", ignore = true)
    Teacher toEntity(CreateTeacherDTO createTeacherDTO);

    // Entity - DTO (Map course entity's ID to courseId in DTO)
    @Mapping(source = "course.id", target = "courseId")
    TeacherResponseDTO toDTO(Teacher teacher);
}