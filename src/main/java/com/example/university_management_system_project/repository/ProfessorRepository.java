package com.example.university_management_system_project.repository;

import com.example.university_management_system_project.entity.Course;
import com.example.university_management_system_project.entity.Professor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfessorRepository extends UserRepository<Professor> {
    Optional<Professor> findByCode(int code);
}
