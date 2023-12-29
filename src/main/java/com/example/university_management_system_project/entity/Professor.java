package com.example.university_management_system_project.entity;

import com.example.university_management_system_project.common.AcademicRank;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Professor extends User {

    @Column(unique = true)
    private int code;

    @Enumerated(EnumType.STRING)
    private AcademicRank academicRank;

    @OneToMany(mappedBy = "professor", cascade = CascadeType.ALL)
    private List<Course> courses;
}
