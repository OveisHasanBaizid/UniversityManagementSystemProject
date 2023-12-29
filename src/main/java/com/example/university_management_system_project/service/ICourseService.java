package com.example.university_management_system_project.service;

import com.example.university_management_system_project.entity.Course;

import java.util.List;
import java.util.Optional;

public interface ICourseService {

    Course update(Course course);

    Course save(Course course);

    void deleteById(Long id);

    Course findById(Long id);

    List<Course> findAll();

}
