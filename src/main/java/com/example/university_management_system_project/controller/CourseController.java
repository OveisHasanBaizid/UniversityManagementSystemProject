package com.example.university_management_system_project.controller;

import com.example.university_management_system_project.dto.CourseDTO;
import com.example.university_management_system_project.dto.ProfessorDTO;
import com.example.university_management_system_project.dto.StudentDTO;
import com.example.university_management_system_project.entity.Course;
import com.example.university_management_system_project.entity.Professor;
import com.example.university_management_system_project.entity.Student;
import com.example.university_management_system_project.mapper.CourseMapper;
import com.example.university_management_system_project.mapper.ProfessorMapper;
import com.example.university_management_system_project.mapper.StudentMapper;
import com.example.university_management_system_project.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course/v1")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;
    private final CourseMapper courseMapper;
    private final StudentMapper studentMapper;
    private final ProfessorMapper professorMapper;

    @PostMapping("/save")
    public ResponseEntity<HttpStatus> save(@RequestBody CourseDTO courseDTO) {
        this.courseService.save(courseMapper.toCourse(courseDTO));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/update")
    public ResponseEntity<HttpStatus> update(@RequestBody CourseDTO courseDTO) {
        this.courseService.update(courseMapper.toCourse(courseDTO));
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id) {
        this.courseService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<CourseDTO> findById(@PathVariable Long id) {
        Course course = this.courseService.findById(id);
        return ResponseEntity.ok(courseMapper.toCourseDTO(course));
    }

    @GetMapping("/list")
    public ResponseEntity<List<CourseDTO>> findAll() {
        List<Course> courses = this.courseService.findAll();
        List<CourseDTO> courseDTOS = courseMapper.toCourseDTOs(courses);
        return ResponseEntity.ok(courseDTOS);
    }

    @GetMapping("/{codeCourse}/students")
    public ResponseEntity<List<StudentDTO>> listStudents(@PathVariable int codeCourse) {
        List<Student> students = courseService.listStudents(codeCourse);
        return ResponseEntity.ok(studentMapper.toStudentDTOs(students));
    }

    @PostMapping("/{codeCourse}/students/add/{stdNumber}")
    public ResponseEntity<HttpStatus> addStudent(@PathVariable int codeCourse
            , @PathVariable long stdNumber) {
        courseService.addStudent(codeCourse, stdNumber);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{codeCourse}/students/delete/{stdNumber}")
    public ResponseEntity<HttpStatus> removeStudent(@PathVariable int codeCourse
            , @PathVariable long stdNumber) {
        courseService.removeStudent(codeCourse, stdNumber);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/{codeCourse}/professor/add/{codeProfessor}")
    public ResponseEntity<HttpStatus> addProfessor(@PathVariable int codeCourse
            , @PathVariable int codeProfessor) {
        courseService.addProfessor(codeCourse,codeProfessor);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{codeCourse}/professor/remove")
    public ResponseEntity<HttpStatus> removeStudent(@PathVariable int codeCourse) {
        courseService.removeProfessor(codeCourse);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @GetMapping("/{codeCourse}/professor")
    public ResponseEntity<ProfessorDTO> getProfessor(@PathVariable int codeCourse) {
        Professor professor = courseService.getProfessor(codeCourse);
        return ResponseEntity.ok(professorMapper.toProfessorDTO(professor));
    }
}
