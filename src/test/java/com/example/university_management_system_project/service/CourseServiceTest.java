package com.example.university_management_system_project.service;

import com.example.university_management_system_project.entity.Course;
import com.example.university_management_system_project.entity.Professor;
import com.example.university_management_system_project.entity.Student;
import com.example.university_management_system_project.repository.CourseRepository;
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
class CourseServiceTest {

    @Mock
    private CourseRepository courseRepository;
    @Mock
    private StudentService studentService;
    @Mock
    private ProfessorService professorService;
    @InjectMocks
    private CourseService courseService;

    static Course course;
    static Student student;
    static Professor professor;

    @Test
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
    void removeProfessor() {
        professor.getCourses().add(course);
        course.setProfessor(professor);

        when(courseRepository.findByCode(1)).thenReturn(Optional.of(course));
        when(courseRepository.findById(1L)).thenReturn(Optional.of(course));
        when(professorService.findByCode(1)).thenReturn(professor);

        courseService.addProfessor(1, 1);

        Assertions.assertEquals(professor, courseRepository.findByCode(1).get().getProfessor());
    }

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
}