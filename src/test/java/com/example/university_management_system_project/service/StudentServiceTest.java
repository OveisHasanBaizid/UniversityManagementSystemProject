package com.example.university_management_system_project.service;

import com.example.university_management_system_project.entity.Student;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {
    @Mock
    private StudentService studentService;

    static Student student;

    @BeforeAll
    public static void createObject(){
        student = new Student();
        student.setId(1L);
        student.setStdNumber(1736716);
    }

    @Test
    void save() {

    }

    @Test
    void findByStdNumber() {
    }

    @Test
    void listCoursesStudent() {
    }
}