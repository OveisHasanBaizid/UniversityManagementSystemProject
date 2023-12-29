package com.example.university_management_system_project.repository;

import com.example.university_management_system_project.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course , Long> {
    Optional<Course> findByCode(int code);
}
