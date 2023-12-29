package com.example.university_management_system_project.controller;

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
    public ResponseEntity<HttpStatus> save(Professor professor) {
        this.professorService.save(professor);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id) {
        this.professorService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Professor> findById(@PathVariable Long id) {
        Professor professor = this.professorService.findById(id);
        return ResponseEntity.ok(professor);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Professor>> findAll() {
        List<Professor> professors = this.professorService.findAll();
        return ResponseEntity.ok(professors);
    }
}
