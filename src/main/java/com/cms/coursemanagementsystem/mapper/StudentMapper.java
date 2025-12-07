package com.cms.coursemanagementsystem.mapper;

import com.cms.coursemanagementsystem.dto.request.student.CreateStudentDTO;
import com.cms.coursemanagementsystem.dto.response.student.StudentResponseDTO;
import com.cms.coursemanagementsystem.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    Student toEntity(CreateStudentDTO createStudentDTO);

    @Mapping(source = "courses", target = "enrolledCourseIds")
    StudentResponseDTO toDTO(Student student);

    default Long courseToCourseId(com.cms.coursemanagementsystem.entity.Course course) {
        return course.getId();
    }
}