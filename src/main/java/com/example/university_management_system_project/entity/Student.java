package com.example.university_management_system_project.entity;

import com.example.university_management_system_project.enums.AcademicLevel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Student extends User {

    @Column(unique = true , nullable = false , updatable = false)
    private long stdNumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AcademicLevel academicLevel;

    @ManyToMany(mappedBy = "students")
    private Set<Course> courses = new HashSet<>();

    public Student(long stdNumber, long nationalCode, String username, String password) {
        this.stdNumber = stdNumber;
        this.setNationalCode(nationalCode);
        this.setUsername(username);
        this.setPassword(password);
        this.setBirthDay(new Date());
    }
}
