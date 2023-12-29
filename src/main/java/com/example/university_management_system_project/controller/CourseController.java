package com.example.university_management_system_project.controller;

import com.example.university_management_system_project.dto_mapper.CourseDTO;
import com.example.university_management_system_project.dto_mapper.CourseMapper;
import com.example.university_management_system_project.entity.Course;
import com.example.university_management_system_project.service.ICourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course/v1")
public class CourseController {

    private final ICourseService courseService;
    private final CourseMapper courseMapper;

    public CourseController(ICourseService courseService, CourseMapper courseMapper) {
        this.courseService = courseService;
        this.courseMapper = courseMapper;
    }

    @PostMapping("/save")
    public ResponseEntity<HttpStatus> save(@RequestBody CourseDTO courseDTO) {
        this.courseService.save(courseMapper.toCourse(courseDTO));
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<HttpStatus> update(@RequestBody CourseDTO courseDTO) {
        this.courseService.update(courseMapper.toCourse(courseDTO));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id) {
        this.courseService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<CourseDTO> findById(@PathVariable Long id) {
        Course course = this.courseService.findById(id);
        return ResponseEntity.ok(courseMapper.toCourseDTO(course));
    }

    @GetMapping("/list")
    public ResponseEntity<List<CourseDTO>> findAll() {
        List<Course> courses = this.courseService.findAll();
        return ResponseEntity.ok(courseMapper.toCourseDTOs(courses));
    }
}
