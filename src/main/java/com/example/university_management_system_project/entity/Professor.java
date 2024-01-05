package com.example.university_management_system_project.entity;

import com.example.university_management_system_project.enums.AcademicRank;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Professor extends User {

    @Column(unique = true , nullable = false , updatable = false)
    private int code;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AcademicRank academicRank;

    @OneToMany(mappedBy = "professor", cascade = CascadeType.ALL)
    private Set<Course> courses = new HashSet<>();
}
