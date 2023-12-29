package com.example.university_management_system_project.dto_mapper;

import com.example.university_management_system_project.common.AcademicLevel;
import com.example.university_management_system_project.common.Gender;
import com.example.university_management_system_project.entity.Course;
import lombok.*;

import java.util.Date;
import java.util.Set;

@EqualsAndHashCode(callSuper=false)
@Data
public class StudentDTO extends UserDTO {

    private long stdNumber;

    private AcademicLevel academicLevel;

    private Set<Course> courses;

    public StudentDTO(Long id, Integer version, Date created, String createdBy
            , Date lastModifiedDate, String lastModifiedBy, String name
            , String family, long nationalCode, Gender gender, Date birthDay
            , String username, String password, long stdNumber, AcademicLevel academicLevel
            , Set<Course> courses) {
        super(id, version, created, createdBy, lastModifiedDate, lastModifiedBy
                , name, family, nationalCode, gender, birthDay, username, password);
        this.stdNumber = stdNumber;
        this.academicLevel = academicLevel;
        this.courses = courses;
    }
}
