package com.example.university_management_system_project.dto_mapper;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
public class CourseDTO extends BaseEntityDTO {

    @Positive
    private int code;

    @NotBlank
    private String title;

    @Positive
    private int units;

    public CourseDTO(Long id, Integer version, Date created, String createdBy
            , Date lastModifiedDate, String lastModifiedBy, int code
            , String title, int units) {
        super(id, version, created, createdBy, lastModifiedDate, lastModifiedBy);
        this.code = code;
        this.title = title;
        this.units = units;
    }
}
