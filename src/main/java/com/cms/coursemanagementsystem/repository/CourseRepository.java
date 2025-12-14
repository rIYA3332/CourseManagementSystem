package com.cms.coursemanagementsystem.repository;

import com.cms.coursemanagementsystem.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    // Custom query to fetch all courses and eagerly load their students (for getAllCourses)
    @Query("SELECT c FROM Course c LEFT JOIN FETCH c.students")
    List<Course> findAllWithStudents();

    // Custom query to fetch a single course and eagerly load its students (for getCourseById)
    @Query("SELECT c FROM Course c LEFT JOIN FETCH c.students WHERE c.id = :id")
    Optional<Course> findByIdWithStudents(@Param("id") Long id);
}