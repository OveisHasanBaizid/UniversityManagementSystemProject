package com.example.university_management_system_project.dto_mapper;

import com.example.university_management_system_project.entity.Course;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    Course toCourse(CourseDTO courseDTO);

    CourseDTO toCourseDTO(Course course);

    List<Course> toCourseList(List<CourseDTO> courseDTOS);

    List<CourseDTO> toCourseDTOs(List<Course> courseList);
}
