package com.example.university_management_system_project.repository;

import com.example.university_management_system_project.entity.Student;
import com.example.university_management_system_project.enums.AcademicLevel;
import com.example.university_management_system_project.enums.Gender;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.Optional;

@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    Student student;

    @BeforeEach
    public void setUp() {
        student = new Student();
        student.setName("Student1");
        student.setFamily("Student1");
        student.setGender(Gender.FEMALE);
        student.setStdNumber(73623442);
        student.setAcademicLevel(AcademicLevel.MASTER);
        student.setBirthDay(new Date());
    }

    @Test
    public void findByStdNumber() {
        studentRepository.save(student);

        Optional<Student> optionalStudent = studentRepository.findByStdNumber(73623442);

        Assertions.assertTrue(optionalStudent.isPresent());
        Assertions.assertEquals(optionalStudent.get().getId(), 1L);
    }
}