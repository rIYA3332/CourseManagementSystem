package com.cms.coursemanagementsystem.repository;

import com.cms.coursemanagementsystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    // New: Custom query to fetch a single student and eagerly load their enrolled courses
    @Query("SELECT s FROM Student s LEFT JOIN FETCH s.courses WHERE s.id = :id")
    Optional<Student> findByIdWithCourses(@Param("id") Long id);
}