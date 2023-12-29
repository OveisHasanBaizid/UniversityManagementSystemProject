package com.example.university_management_system_project.dto_mapper;

import com.example.university_management_system_project.entity.Professor;
import com.example.university_management_system_project.entity.Student;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.Set;

@EqualsAndHashCode(callSuper = false)
@Data
public class CourseDTO extends BaseEntityDTO {

    @Positive
    private int code;

    @NotBlank
    private String title;

    @Positive
    private int units;

    private Professor professor;

    private Set<Student> students;

    public CourseDTO(Long id, Integer version, Date created, String createdBy
            , Date lastModifiedDate, String lastModifiedBy, int code
            , String title, int units, Professor professor
            , Set<Student> students) {
        super(id, version, created, createdBy, lastModifiedDate, lastModifiedBy);
        this.code = code;
        this.title = title;
        this.units = units;
        this.professor = professor;
        this.students = students;
    }
}
