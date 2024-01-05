package com.example.university_management_system_project.mapper;

import com.example.university_management_system_project.dto.ProfessorDTO;
import com.example.university_management_system_project.entity.Professor;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProfessorMapper {
    Professor toProfessor(ProfessorDTO professorDTO);

    ProfessorDTO toProfessorDTO(Professor professor);

    List<Professor> toProfessorList(List<ProfessorDTO> professorDTOS);

    List<ProfessorDTO> toProfessorDTOs(List<Professor> professorList);
}
