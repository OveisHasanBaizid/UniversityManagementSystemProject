package com.example.university_management_system_project.dto_mapper;

import com.example.university_management_system_project.common.AcademicRank;
import com.example.university_management_system_project.common.Gender;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper=false)
@Data
public class ProfessorDTO extends UserDTO {

    @Positive
    private int code;

    @NotNull
    private AcademicRank academicRank;

    public ProfessorDTO(Long id, Integer version, Date created, String createdBy
            , Date lastModifiedDate, String lastModifiedBy, String name, String family
            , long nationalCode, Gender gender, Date birthDay, String username
            , String password, int code, AcademicRank academicRank) {
        super(id, version, created, createdBy, lastModifiedDate, lastModifiedBy, name
                , family, nationalCode, gender, birthDay, username, password);
        this.code = code;
        this.academicRank = academicRank;
    }
}
