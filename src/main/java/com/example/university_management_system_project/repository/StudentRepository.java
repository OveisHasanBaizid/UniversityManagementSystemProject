package com.example.university_management_system_project.repository;

import com.example.university_management_system_project.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends UserRepository<Student> {
    Optional<Student> findByStdNumber(long stdNumber);
}
