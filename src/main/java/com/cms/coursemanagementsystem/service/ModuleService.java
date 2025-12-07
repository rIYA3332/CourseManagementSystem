package com.cms.coursemanagementsystem.service;

import com.cms.coursemanagementsystem.dto.request.module.CreateModuleDTO;
import com.cms.coursemanagementsystem.dto.response.module.ModuleResponseDTO;

import java.util.List;

public interface ModuleService {
    ModuleResponseDTO createModule(CreateModuleDTO moduleDTO);
    List<ModuleResponseDTO> getAllModules();
    ModuleResponseDTO getModuleById(Long id);
    ModuleResponseDTO updateModule(Long id, CreateModuleDTO moduleDTO);
    String deleteModule(Long id);
}