package com.cms.coursemanagementsystem.service.impl;

import com.cms.coursemanagementsystem.dto.request.module.CreateModuleDTO;
import com.cms.coursemanagementsystem.dto.response.module.ModuleResponseDTO;
import com.cms.coursemanagementsystem.entity.Course;
import com.cms.coursemanagementsystem.entity.Module;
import com.cms.coursemanagementsystem.mapper.ModuleMapper;
import com.cms.coursemanagementsystem.repository.CourseRepository;
import com.cms.coursemanagementsystem.repository.ModuleRepository;
import com.cms.coursemanagementsystem.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ModuleServiceImpl implements ModuleService {

    @Autowired
    private ModuleRepository moduleRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private ModuleMapper moduleMapper;

    @Override
    public ModuleResponseDTO createModule(CreateModuleDTO moduleDTO) {
        Course course = courseRepository.findById(moduleDTO.courseId())
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + moduleDTO.courseId()));

        Module module = moduleMapper.toEntity(moduleDTO);
        module.setCourse(course);

        Module savedModule = moduleRepository.save(module);
        return moduleMapper.toDTO(savedModule);
    }

    @Override
    public List<ModuleResponseDTO> getAllModules() {
        return moduleRepository.findAll()
                .stream()
                .map(moduleMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ModuleResponseDTO getModuleById(Long id) {
        Module module = moduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Module not found with id: " + id));
        return moduleMapper.toDTO(module);
    }

    @Override
    public ModuleResponseDTO updateModule(Long id, CreateModuleDTO moduleDTO) {
        Module module = moduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Module not found with id: " + id));

        Course course = courseRepository.findById(moduleDTO.courseId())
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + moduleDTO.courseId()));

        module.setModuleName(moduleDTO.moduleName());
        module.setContent(moduleDTO.content());
        module.setCourse(course);

        Module updatedModule = moduleRepository.save(module);
        return moduleMapper.toDTO(updatedModule);
    }

    @Override
    public String deleteModule(Long id) {
        Module module = moduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Module not found with id: " + id));

        moduleRepository.delete(module);
        return "Module with id " + id + " deleted successfully!";
    }
}