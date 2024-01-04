package com.example.university_management_system_project.service;

import com.example.university_management_system_project.entity.Course;
import com.example.university_management_system_project.entity.Professor;
import com.example.university_management_system_project.entity.Student;
import com.example.university_management_system_project.repository.CourseRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@EnabledOnOs({OS.WINDOWS})
//@EnabledForJreRange(min = JRE.JAVA_8 , max = JRE.JAVA_21)
class CourseServiceTest {

    static Course course;
    static Student student;
    static Professor professor;

    @Mock
    private CourseRepository courseRepository;
    @Mock
    private StudentService studentService;
    @Mock
    private ProfessorService professorService;
    @InjectMocks
    private CourseService courseService;

    @BeforeAll
    public static void createObject() {
        professor = new Professor();
        professor.setId(1L);
        professor.setCode(1);

        course = new Course();
        course.setId(1L);
        course.setCode(1);

        student = new Student();
        student.setId(1L);
        student.setStdNumber(1736716);
    }

    @Test
    @DisplayName("Add new student to course")
    @Order(1)
    void addStudent() {
        student.getCourses().add(course);
        course.getStudents().add(student);

        when(courseRepository.findByCode(1)).thenReturn(Optional.of(course));
        when(courseRepository.findById(1L)).thenReturn(Optional.of(course));
        when(studentService.findByStdNumber(1736716L)).thenReturn(student);

        courseService.addStudent(1, 1736716);

        Assertions.assertSame(1, courseRepository.findByCode(1).get().getStudents().size());
    }

    @Test
    @DisplayName("Remove student of course")
    @Order(2)
    void removeStudent() {
        student.getCourses().add(course);
        course.getStudents().add(student);

        when(courseRepository.findByCode(1)).thenReturn(Optional.of(course));
        when(courseRepository.findById(1L)).thenReturn(Optional.of(course));
        when(studentService.findByStdNumber(1736716L)).thenReturn(student);

        courseService.removeStudent(1, 1736716);

        Assertions.assertSame(0, courseRepository.findByCode(1).get().getStudents().size());
    }

    @Test
    @DisplayName("Add Professor to course")
    @Order(3)
    void addProfessor() {
        professor.getCourses().add(course);
        course.setProfessor(professor);

        when(courseRepository.findByCode(1)).thenReturn(Optional.of(course));
        when(courseRepository.findById(1L)).thenReturn(Optional.of(course));
        when(professorService.findByCode(1)).thenReturn(professor);

        courseService.addProfessor(1, 1);

        Assertions.assertEquals(professor, courseRepository.findByCode(1).get().getProfessor());
    }

    @Test
    @DisplayName("Remove Professor of course")
    @Order(4)
    void removeProfessor() {
        professor.getCourses().add(course);
        course.setProfessor(professor);

        when(courseRepository.findByCode(1)).thenReturn(Optional.of(course));
        when(courseRepository.findById(1L)).thenReturn(Optional.of(course));
        when(professorService.findByCode(1)).thenReturn(professor);

        courseService.addProfessor(1, 1);

        Assertions.assertEquals(professor, courseRepository.findByCode(1).get().getProfessor());
    }
}