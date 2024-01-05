package com.example.university_management_system_project.dto;

import com.example.university_management_system_project.enums.AcademicLevel;
import com.example.university_management_system_project.enums.Gender;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper=false)
@Data
public class StudentDTO extends UserDTO {

    @Positive
    private long stdNumber;

    @NotNull
    private AcademicLevel academicLevel;

    public StudentDTO(Long id, Integer version, Date created, String createdBy
            , Date lastModifiedDate, String lastModifiedBy, String name
            , String family, long nationalCode, Gender gender, Date birthDay
            , String username, String password, long stdNumber, AcademicLevel academicLevel) {
        super(id, version, created, createdBy, lastModifiedDate, lastModifiedBy
                , name, family, nationalCode, gender, birthDay, username, password);
        this.stdNumber = stdNumber;
        this.academicLevel = academicLevel;
    }
}
