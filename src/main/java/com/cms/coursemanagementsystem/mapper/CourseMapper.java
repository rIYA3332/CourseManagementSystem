package com.cms.coursemanagementsystem.mapper;

import com.cms.coursemanagementsystem.dto.request.course.CreateCourseDTO;
import com.cms.coursemanagementsystem.dto.response.course.CourseResponseDTO;
import com.cms.coursemanagementsystem.entity.Course;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);

    // DTO - Entity
    Course toEntity(CreateCourseDTO createCourseDTO);

    // Entity - DTO
    CourseResponseDTO toDTO(Course course);
}
