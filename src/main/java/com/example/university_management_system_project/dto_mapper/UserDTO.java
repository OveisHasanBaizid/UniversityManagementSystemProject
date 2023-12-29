package com.example.university_management_system_project.dto_mapper;

import com.example.university_management_system_project.common.Gender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.util.Date;

@EqualsAndHashCode(callSuper=false)
@Data
@NoArgsConstructor
public class UserDTO extends BaseEntityDTO {

    @NotBlank
    private String name;

    @NotBlank
    private String family;

    @Positive
    private long nationalCode;

    @NotNull
    private Gender gender;

    @NotNull
    private Date birthDay;

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    public UserDTO(Long id, Integer version, Date created, String createdBy
            , Date lastModifiedDate, String lastModifiedBy, String name, String family
            , long nationalCode, Gender gender, Date birthDay, String username, String password) {
        super(id, version, created, createdBy, lastModifiedDate, lastModifiedBy);
        this.name = name;
        this.family = family;
        this.nationalCode = nationalCode;
        this.gender = gender;
        this.birthDay = birthDay;
        this.username = username;
        this.password = password;
    }
}
