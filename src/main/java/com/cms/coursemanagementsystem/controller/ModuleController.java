package com.cms.coursemanagementsystem.controller;

import com.cms.coursemanagementsystem.dto.request.module.CreateModuleDTO;
import com.cms.coursemanagementsystem.dto.response.module.ModuleResponseDTO;
import com.cms.coursemanagementsystem.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/modules")
public class ModuleController {

    @Autowired
    private ModuleService moduleService;

    @PostMapping
    public ModuleResponseDTO createModule(@RequestBody CreateModuleDTO moduleDTO) {
        return moduleService.createModule(moduleDTO);
    }

    @GetMapping
    public List<ModuleResponseDTO> getAllModules() {
        return moduleService.getAllModules();
    }

    @GetMapping("/{id}")
    public ModuleResponseDTO getModuleById(@PathVariable Long id) {
        return moduleService.getModuleById(id);
    }

    @PutMapping("/{id}")
    public ModuleResponseDTO updateModule(@PathVariable Long id, @RequestBody CreateModuleDTO moduleDTO) {
        return moduleService.updateModule(id, moduleDTO);
    }

    @DeleteMapping("/{id}")
    public String deleteModule(@PathVariable Long id) {
        return moduleService.deleteModule(id);
    }
}