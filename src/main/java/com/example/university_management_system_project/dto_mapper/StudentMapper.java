package com.example.university_management_system_project.dto_mapper;

import com.example.university_management_system_project.entity.Student;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    Student toStudent(StudentDTO studentDTO);

    StudentDTO toStudentDTO(Student student);

    List<Student> toStudentList(List<StudentDTO> studentDTOS);

    List<StudentDTO> toStudentDTOs(List<Student> studentList);
}
