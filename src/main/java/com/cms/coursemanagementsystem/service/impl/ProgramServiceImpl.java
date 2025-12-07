package com.cms.coursemanagementsystem.service.impl;

import com.cms.coursemanagementsystem.dto.request.program.CreateProgramDTO;
import com.cms.coursemanagementsystem.dto.response.program.ProgramResponseDTO;
import com.cms.coursemanagementsystem.entity.Program;
import com.cms.coursemanagementsystem.mapper.ProgramMapper;
import com.cms.coursemanagementsystem.repository.ProgramRepository;
import com.cms.coursemanagementsystem.service.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProgramServiceImpl implements ProgramService {

    @Autowired
    private ProgramRepository programRepository;

    @Autowired
    private ProgramMapper programMapper;

    @Override
    public ProgramResponseDTO createProgram(CreateProgramDTO programDTO) {
        Program program = programMapper.toEntity(programDTO);
        Program savedProgram = programRepository.save(program);
        return programMapper.toDTO(savedProgram);
    }

    @Override
    public List<ProgramResponseDTO> getAllPrograms() {
        return programRepository.findAll()
                .stream()
                .map(programMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProgramResponseDTO getProgramById(Long id) {
        Program program = programRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Program not found with id: " + id));
        return programMapper.toDTO(program);
    }

    @Override
    public ProgramResponseDTO updateProgram(Long id, CreateProgramDTO programDTO) {
        Program program = programRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Program not found with id: " + id));

        program.setProgramName(programDTO.programName());
        program.setDescription(programDTO.description());

        Program updatedProgram = programRepository.save(program);
        return programMapper.toDTO(updatedProgram);
    }

    @Override
    public String deleteProgram(Long id) {
        Program program = programRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Program not found with id: " + id));

        programRepository.delete(program);
        return "Program with id " + id + " deleted successfully!";
    }
}