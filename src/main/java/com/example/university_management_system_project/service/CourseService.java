package com.example.university_management_system_project.service;

import com.example.university_management_system_project.entity.Course;
import com.example.university_management_system_project.entity.Professor;
import com.example.university_management_system_project.entity.Student;
import com.example.university_management_system_project.exception.ConflictException;
import com.example.university_management_system_project.exception.NotFoundException;
import com.example.university_management_system_project.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseService implements ICourseService {
    private final CourseRepository courseRepository;
    private final StudentService studentService;
    private final ProfessorService professorService;

    @Override
    public Course update(Course course) {
        //It checks if this code already exists or not
        findById(course.getId());
        return courseRepository.save(course);
    }

    @Override
    public Course save(Course course) {
        //It checks if this code already exists or not
        Optional<Course> optional = courseRepository.findByCode(course.getCode());
        if (optional.isPresent())
            throw new ConflictException("The course with the desired code is available in the system.");
        return courseRepository.save(course);
    }

    @Override
    public void deleteById(Long id) {
        //It checks if this code already exists or not
        findById(id);
        courseRepository.deleteById(id);
    }

    @Override
    public Course findById(Long id) {
        Optional<Course> optional = courseRepository.findById(id);
        if (optional.isEmpty())
            throw new NotFoundException("Course Not found.");
        return optional.get();
    }

    @Override
    public Course findByCode(int code) {
        Optional<Course> optionalCourse = courseRepository.findByCode(code);
        if (optionalCourse.isEmpty())
            throw new NotFoundException("Course Not found.");
        return optionalCourse.get();
    }

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public void addStudent(int codeCourse, long stdNumber) {
        Student student = studentService.findByStdNumber(stdNumber);
        Course course = findByCode(codeCourse);
        course.getStudents().add(student);
        student.getCourses().add(course);

        studentService.update(student);
        update(course);
    }

    @Override
    public List<Student> listStudents(int codeCourse) {
        return findByCode(codeCourse).getStudents().stream().toList();
    }

    @Override
    public void removeStudent(int codeCourse, long stdNumber) {
        Student student = studentService.findByStdNumber(stdNumber);
        Course course = findByCode(codeCourse);
        if (!course.getStudents().contains(student))
            throw new NotFoundException("The student does not have this course.");
        course.getStudents().remove(student);
        student.getCourses().remove(course);

        studentService.update(student);
        update(course);
    }

    @Override
    public void addProfessor(int codeCourse, int codeProfessor) {
        Professor professor = professorService.findByCode(codeProfessor);
        Course course = findByCode(codeCourse);
        course.setProfessor(professor);
        professor.getCourses().add(course);

        professorService.update(professor);
        update(course);
    }

    @Override
    public void removeProfessor(int codeCourse) {
        Course course = findByCode(codeCourse);
        if (course.getProfessor() == null)
            throw new NotFoundException("The professor is not set for this course.");
        Professor professor = course.getProfessor();
        course.setProfessor(null);
        professor.getCourses().remove(course);

        professorService.update(professor);
        update(course);
    }

    @Override
    public Professor getProfessor(int codeCourse) {
        Course course = findByCode(codeCourse);
        if (course.getProfessor() == null)
            throw new NotFoundException("The professor is not set for this course.");
        return course.getProfessor();
    }
}
