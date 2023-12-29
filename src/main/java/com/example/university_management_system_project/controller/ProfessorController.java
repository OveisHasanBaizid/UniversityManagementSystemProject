package com.example.university_management_system_project.controller;

import com.example.university_management_system_project.dto_mapper.ProfessorDTO;
import com.example.university_management_system_project.dto_mapper.ProfessorMapper;
import com.example.university_management_system_project.entity.Professor;
import com.example.university_management_system_project.service.IProfessorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professor/v1")
public class ProfessorController {

    private final IProfessorService professorService;
    private final ProfessorMapper professorMapper;

    public ProfessorController(IProfessorService professorService, ProfessorMapper professorMapper) {
        this.professorService = professorService;
        this.professorMapper = professorMapper;
    }

    @PostMapping("/save")
    public ResponseEntity<HttpStatus> save(ProfessorDTO professorDTO) {
        this.professorService.save(professorMapper.toProfessor(professorDTO));
        return ResponseEntity.ok(HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<HttpStatus> update(ProfessorDTO professorDTO) {
        this.professorService.update(professorMapper.toProfessor(professorDTO));
        return ResponseEntity.ok(HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id) {
        this.professorService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<ProfessorDTO> findById(@PathVariable Long id) {
        Professor professor = this.professorService.findById(id);
        return ResponseEntity.ok(professorMapper.toProfessorDTO(professor));
    }

    @GetMapping("/list")
    public ResponseEntity<List<ProfessorDTO>> findAll() {
        List<Professor> professors = this.professorService.findAll();
        return ResponseEntity.ok(professorMapper.toProfessorDTOs(professors));
    }
}
