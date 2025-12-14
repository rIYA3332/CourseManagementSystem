package com.cms.coursemanagementsystem.mapper;

import com.cms.coursemanagementsystem.dto.request.course.CreateCourseDTO;
import com.cms.coursemanagementsystem.dto.response.course.CourseResponseDTO;
import com.cms.coursemanagementsystem.entity.Course;
import com.cms.coursemanagementsystem.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);

    // DTO -> Entity
    Course toEntity(CreateCourseDTO createCourseDTO);

    // Entity -> DTO (Mapping the students Set)
    @Mapping(target = "enrolledStudentIds", source = "students") // Map the 'students' field in Course to 'enrolledStudentIds' in DTO
    CourseResponseDTO toDTO(Course course);

    default Set<Long> mapStudentsToStudentIds(Set<Student> students) {
        if (students == null) {
            return Set.of();
        }

        return students.stream()
                .map(Student::getId)
                .collect(Collectors.toSet());
    }
}