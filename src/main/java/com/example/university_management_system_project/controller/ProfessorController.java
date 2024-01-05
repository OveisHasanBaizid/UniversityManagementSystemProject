package com.example.university_management_system_project.controller;

import com.example.university_management_system_project.dto.CourseDTO;
import com.example.university_management_system_project.mapper.CourseMapper;
import com.example.university_management_system_project.dto.ProfessorDTO;
import com.example.university_management_system_project.mapper.ProfessorMapper;
import com.example.university_management_system_project.entity.Course;
import com.example.university_management_system_project.entity.Professor;
import com.example.university_management_system_project.service.IProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professor/v1")
@RequiredArgsConstructor
public class ProfessorController {

    private final IProfessorService professorService;
    private final ProfessorMapper professorMapper;
    private final CourseMapper courseMapper;

    @PostMapping("/save")
    public ResponseEntity<HttpStatus> save(@RequestBody ProfessorDTO professorDTO) {
        this.professorService.save(professorMapper.toProfessor(professorDTO));
        return ResponseEntity.ok(HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<HttpStatus> update(@RequestBody ProfessorDTO professorDTO) {
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

    @GetMapping("/{codeProfessor}/course/list")
    public ResponseEntity<List<CourseDTO>> listCoursesProfessor(@PathVariable int codeProfessor) {
        List<Course> courses = professorService.listCoursesProfessor(codeProfessor);
        return ResponseEntity.ok(courseMapper.toCourseDTOs(courses));
    }
}
