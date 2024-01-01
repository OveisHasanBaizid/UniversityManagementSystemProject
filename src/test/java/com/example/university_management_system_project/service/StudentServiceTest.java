package com.example.university_management_system_project.service;

import com.example.university_management_system_project.entity.Student;
import com.example.university_management_system_project.exception.ConflictException;
import com.example.university_management_system_project.exception.NotFoundException;
import com.example.university_management_system_project.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;
    @InjectMocks
    private StudentService studentService;

    static Student student;

    @BeforeAll
    public static void createObject(){
        student = new Student();
        student.setStdNumber(1736716);
        student.setNationalCode(8239429498L);
        student.setUsername("username1");
    }

    @Test
    void saveWithThrowConflictException() {
        when(studentRepository.findByNationalCode(8239429498L)).thenReturn(Optional.empty());
        when(studentRepository.findByUsername("username1")).thenReturn(Optional.of(student));

        Assertions.assertThrows(ConflictException.class
                , () -> studentService.save(student));
    }
    @Test
    void save() {
        when(studentRepository.findByNationalCode(8239429498L)).thenReturn(Optional.empty());
        when(studentRepository.findByUsername("username1")).thenReturn(Optional.empty());

        when(studentRepository.save(student))
                .then(invocation -> {
                    Student studentArgument = invocation.getArgument(0);
                    studentArgument.setId(1L);
                    return studentArgument;
                });

        Assertions.assertEquals(1L,studentService.save(student).getId());
    }
    @Test
    void findByIdWithThrowNotFoundException() {
        when(studentRepository.findById(8L)).thenReturn(Optional.empty());

        Assertions.assertThrows(NotFoundException.class
                , () -> studentService.findById(8L));
    }


}