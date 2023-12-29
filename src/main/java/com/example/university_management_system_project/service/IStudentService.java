package com.example.university_management_system_project.service;

import com.example.university_management_system_project.entity.Student;

import java.util.List;

public interface IStudentService {

    Student save(Student student);

    Student update(Student student);

    void deleteById(Long id);

    Student findById(Long id);

    List<Student> findAll();



}
