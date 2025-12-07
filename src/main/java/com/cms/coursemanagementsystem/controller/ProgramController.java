package com.cms.coursemanagementsystem.controller;

import com.cms.coursemanagementsystem.dto.request.program.CreateProgramDTO;
import com.cms.coursemanagementsystem.dto.response.program.ProgramResponseDTO;
import com.cms.coursemanagementsystem.service.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/programs")
public class ProgramController {

    @Autowired
    private ProgramService programService;

    @PostMapping
    public ProgramResponseDTO createProgram(@RequestBody CreateProgramDTO programDTO) {
        return programService.createProgram(programDTO);
    }

    @GetMapping
    public List<ProgramResponseDTO> getAllPrograms() {
        return programService.getAllPrograms();
    }

    @GetMapping("/{id}")
    public ProgramResponseDTO getProgramById(@PathVariable Long id) {
        return programService.getProgramById(id);
    }

    @PutMapping("/{id}")
    public ProgramResponseDTO updateProgram(@PathVariable Long id, @RequestBody CreateProgramDTO programDTO) {
        return programService.updateProgram(id, programDTO);
    }

    @DeleteMapping("/{id}")
    public String deleteProgram(@PathVariable Long id) {
        return programService.deleteProgram(id);
    }
}