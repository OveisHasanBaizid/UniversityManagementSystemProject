package com.example.university_management_system_project.service;

import com.example.university_management_system_project.entity.Professor;

import java.util.List;

public interface IProfessorService {

    Professor save(Professor professor);

    void delete(Long id);

    Professor findById(Long id);

    List<Professor> findAll();

}
