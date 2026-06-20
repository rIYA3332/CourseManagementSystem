package com.cms.coursemanagementsystem.mapper;

import com.cms.coursemanagementsystem.dto.request.module.CreateModuleDTO;
import com.cms.coursemanagementsystem.dto.response.module.ModuleResponseDTO;
import com.cms.coursemanagementsystem.entity.Module;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ModuleMapper {

    ModuleMapper INSTANCE = Mappers.getMapper(ModuleMapper.class);

    // DTO - Entity
    @Mapping(target = "course", ignore = true) // Course is set in the service layer
    Module toEntity(CreateModuleDTO createModuleDTO);

    // Entity - DTO
    @Mapping(source = "course.id", target = "courseId") // Map course entity's ID to courseId in DTO
    ModuleResponseDTO toDTO(Module module);
}