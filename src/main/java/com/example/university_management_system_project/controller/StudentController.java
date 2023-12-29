package com.example.university_management_system_project.controller;

import com.example.university_management_system_project.dto_mapper.StudentDTO;
import com.example.university_management_system_project.dto_mapper.StudentMapper;
import com.example.university_management_system_project.entity.Student;
import com.example.university_management_system_project.service.IStudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student/v1")
public class StudentController {

    private final IStudentService studentService;
    private final StudentMapper studentMapper;

    public StudentController(IStudentService studentService, StudentMapper studentMapper) {
        this.studentService = studentService;
        this.studentMapper = studentMapper;
    }

    @PostMapping("/save")
    public ResponseEntity<HttpStatus> save(StudentDTO studentDTO) {
        this.studentService.save(studentMapper.toStudent(studentDTO));
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<HttpStatus> update(StudentDTO studentDTO) {
        this.studentService.update(studentMapper.toStudent(studentDTO));
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id) {
        this.studentService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<StudentDTO> findById(@PathVariable Long id) {
        Student student = this.studentService.findById(id);
        return ResponseEntity.ok(studentMapper.toStudentDTO(student));
    }

    @GetMapping("/list")
    public ResponseEntity<List<StudentDTO>> findAll() {
        List<Student> students = this.studentService.findAll();
        List<StudentDTO> studentDTOS = studentMapper.toStudentDTOs(students);
        return ResponseEntity.ok(studentDTOS);
    }
}
