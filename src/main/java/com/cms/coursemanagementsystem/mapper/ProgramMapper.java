package com.cms.coursemanagementsystem.mapper;

import com.cms.coursemanagementsystem.dto.request.program.CreateProgramDTO;
import com.cms.coursemanagementsystem.dto.response.program.ProgramResponseDTO;
import com.cms.coursemanagementsystem.entity.Program;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProgramMapper {

    ProgramMapper INSTANCE = Mappers.getMapper(ProgramMapper.class);

    Program toEntity(CreateProgramDTO createProgramDTO);

    ProgramResponseDTO toDTO(Program program);
}