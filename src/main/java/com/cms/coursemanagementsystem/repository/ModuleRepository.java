package com.cms.coursemanagementsystem.repository;

import com.cms.coursemanagementsystem.entity.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuleRepository extends JpaRepository<Module, Long> {
}