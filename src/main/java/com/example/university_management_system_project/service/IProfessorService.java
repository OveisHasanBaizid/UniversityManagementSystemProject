package com.example.university_management_system_project.service;

import com.example.university_management_system_project.entity.Course;
import com.example.university_management_system_project.entity.Professor;

import java.util.List;

public interface IProfessorService {

    Professor save(Professor professor);

    Professor update(Professor professor);

    void deleteById(Long id);

    Professor findById(Long id);

    List<Professor> findAll();

    Professor findByCode(int code);

    List<Course> listCoursesProfessor(int code);
}
