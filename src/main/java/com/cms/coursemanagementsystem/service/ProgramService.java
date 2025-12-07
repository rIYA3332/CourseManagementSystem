package com.cms.coursemanagementsystem.service;

import com.cms.coursemanagementsystem.dto.request.program.CreateProgramDTO;
import com.cms.coursemanagementsystem.dto.response.program.ProgramResponseDTO;

import java.util.List;

public interface ProgramService {
    ProgramResponseDTO createProgram(CreateProgramDTO programDTO);
    List<ProgramResponseDTO> getAllPrograms();
    ProgramResponseDTO getProgramById(Long id);
    ProgramResponseDTO updateProgram(Long id, CreateProgramDTO programDTO);
    String deleteProgram(Long id);
}