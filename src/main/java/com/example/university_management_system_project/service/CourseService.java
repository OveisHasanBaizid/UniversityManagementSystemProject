package com.example.university_management_system_project.service;

import com.example.university_management_system_project.entity.Course;
import com.example.university_management_system_project.exception.ConflictException;
import com.example.university_management_system_project.exception.NotFoundException;
import com.example.university_management_system_project.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService implements ICourseService {
    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

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
    public List<Course> findAll() {
        return courseRepository.findAll();
    }
}
