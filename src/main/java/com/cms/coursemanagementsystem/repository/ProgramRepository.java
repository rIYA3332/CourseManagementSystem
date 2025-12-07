package com.cms.coursemanagementsystem.repository;

import com.cms.coursemanagementsystem.entity.Program;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramRepository extends JpaRepository<Program, Long> {
}