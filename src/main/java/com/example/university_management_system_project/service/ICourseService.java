package com.example.university_management_system_project.service;

import com.example.university_management_system_project.entity.Course;
import com.example.university_management_system_project.entity.Student;

import java.util.List;
import java.util.Optional;

public interface ICourseService {

    Course update(Course course);

    Course save(Course course);

    void deleteById(Long id);

    Course findById(Long id);

    Course findByCode(int code);

    List<Course> findAll();

    void addStudent(int codeCourse , long stdStudent);

    List<Student> listStudents(int codeCourse);

    void removeStudent(int codeCourse , long stdStudent);

    void addProfessor(int codeCourse , int codeProfessor);

    void removeProfessor(int codeCourse , int codeProfessor);
}
