package com.example.university_management_system_project.dto_mapper;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntityDTO {

    private Long id;

    private Integer version;

    private Date created;

    private String createdBy;

    private Date lastModifiedDate;

    private String lastModifiedBy;

}
